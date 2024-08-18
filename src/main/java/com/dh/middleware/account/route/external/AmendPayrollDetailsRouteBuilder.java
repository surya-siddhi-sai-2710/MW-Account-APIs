package com.dh.middleware.account.route.external;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.account.models.AmendmentPayrollDetails;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentRequestTypeBknd;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentRequestBknd;
import com.dh.middleware.account.models.backends.bancs.UpdatePayrollDetails_007089;


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
				.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"MANDATORYVALUE\",\"\",\"\",\"\",\"sysOrAppWithoutBkndError\",${exchange})");
			
		from("direct:getInquirePayrollDetails")
			.to("bean:amendPayrollDetailsService?method=prepareInquirePayrollDetails")

			.marshal(new JacksonDataFormat(PayrollDetailsAmendmentRequestBknd.class))

			.setHeader("system",constant("BANCS"))
			.to("{{BANCSDBConnector.host}}{{BANCSDBConnector.contextPath}}"+"/v1/AmendInquirePayrollDetails?bridgeEndpoint=true")
					
			.choice()
				.when().simple("${body} != null")
						.to("bean:amendPayrollDetailsService?method=prepareInquirePayrollBancsResponse")
						.to("bean:amendPayrollDetailsService?method=prepareInquirePayrollDetailsResponse")
						.setHeader("Content-Type", constant("application/json"))
					
				.otherwise()
						.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"RECORDNOTFOUND\",\"\",\"\",\"\",\"sysOrAppWithoutBkndError\",${exchange})")
			.endChoice();

		from("direct:getUpdatePayrollDetails")
			.to("bean:amendPayrollDetailsService?method=prepareUpdatePayrollDetails")
				
			.marshal(new JacksonDataFormat(UpdatePayrollDetails_007089.class))

			.setHeader("system",constant("BANCS"))
			.to("{{BANCSDBConnector.host}}{{BANCSDBConnector.contextPath}}"+"/v1/AmendUpdatePayrollDetails?bridgeEndpoint=true")
			.choice()
					.when().jsonpath("$.PayrollDetailsAmendmentResponse['success']['update']")
						.to("bean:amendPayrollDetailsService?method=prepareUpdatePayrollDetailsResponse")
						.setHeader("Content-Type", constant("application/json"))
					.otherwise()
						.to("bean:oUtils?method=prepareFaultNodeStr(\"PayrollDetailsAmendmentResponse\",\"RECORDNOTFOUND\",\"\",\"\",\"\",\"sysOrAppWithoutBkndError\",${exchange})")
			.endChoice();
		
		
	}
}
