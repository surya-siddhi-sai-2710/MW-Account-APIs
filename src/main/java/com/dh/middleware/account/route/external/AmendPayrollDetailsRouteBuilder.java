package com.dh.middleware.account.route.external;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.account.models.AmendmentPayrollDetails;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentRequestBknd;
import com.dh.middleware.account.models.backends.bancs.UpdatePayrollDetails;


@Component
public class AmendPayrollDetailsRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		restConfiguration().bindingMode(RestBindingMode.json);

		rest("/api/accounts")
		.post("/v1/AmendPayrollDetails")
		.type(AmendmentPayrollDetails.class)
		.consumes("application/json").produces("application/json")
		.to("direct:getAmendPayrollDetails")
		.outType(AmendmentPayrollDetails.class);
		
		onException(Exception.class)
		.to("bean:oUtils?method=onException(${exchange},\"PayrollDetailsAmendmentResponse\",${header.system})")
		.handled(true);
		
		from("direct:getAmendPayrollDetails").routeId("AmendPayrollDetails")
		.setHeader("system", constant("MW"))
		
		.to("bean:amendPayrollDetailsService?method=getPayrollDetailsAmendmentRequestIn")
		.choice()
			.when(simple("${body.payrollDetailsAmendmentRequest.operationMode} == 'R' "))
				.to("direct:getInquirePayrollDetails")
			
			.when(simple("${body.payrollDetailsAmendmentRequest.operationMode} == 'U' "))
				.to("direct:getUpdatePayrollDetails")
			
			.otherwise()
				.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"MANDATORYVALUE\",\"Invalid Operational Mode\",\"\",\"\",\"validationsCust\",${exchange})");
			
		from("direct:getInquirePayrollDetails")
			.to("bean:amendPayrollDetailsService?method=prepareInquirePayrollDetails")

			.marshal(new JacksonDataFormat(PayrollDetailsAmendmentRequestBknd.class))

			.setHeader("system",constant("BANCSDB"))
			.to("{{BANCSDBConnector.host}}{{BANCSDBConnector.contextPath}}"+"/v1/AmendInquirePayrollDetails?bridgeEndpoint=true")
					
			.choice()
				.when().jsonpath("$.PayrollDetailsAmendmentResponse[?(@.ERROR.size()>0)]")
						.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"BANCSDB\",\"\",\"\",\"\",\"sysOrAppWithBkndError\",${exchange})")
				.otherwise()
						.to("bean:amendPayrollDetailsService?method=prepareInquirePayrollResponse")
			.endChoice();

		from("direct:getUpdatePayrollDetails")
			.to("bean:amendPayrollDetailsService?method=prepareUpdatePayrollDetails")
				
			.marshal(new JacksonDataFormat(UpdatePayrollDetails.class))

			.setHeader("system",constant("BANCSDB"))
			.to("{{BANCSDBConnector.host}}{{BANCSDBConnector.contextPath}}"+"/v1/AmendUpdatePayrollDetails?bridgeEndpoint=true")

			.choice()
				.when().jsonpath("$.PayrollDetailsAmendmentResponse[?(@.ERROR.size()>0)]")
						.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"BANCSDB\",\"\",\"\",\"\",\"sysOrAppWithBkndError\",${exchange})")

				.otherwise()
						.to("bean:amendPayrollDetailsService?method=prepareUpdatePayrollDetailsResponse")
			.endChoice();
		
		
	}
}
