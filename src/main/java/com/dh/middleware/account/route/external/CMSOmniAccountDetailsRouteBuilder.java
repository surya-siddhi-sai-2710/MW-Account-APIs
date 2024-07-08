package com.dh.middleware.account.route.external;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.account.models.CMSBulkAccountCreation;
import com.dh.middleware.account.models.CMSOmniAccountDetails;
import com.dh.middleware.account.models.backend.cms.ProcessRequest;

@Component
public class CMSOmniAccountDetailsRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);

		rest("/api/accounts")
		.post("/v1/CMSOmniAccountDetails")
		.type(CMSOmniAccountDetails.class)
		.consumes("application/json")
		.produces("application/json")
		.to("direct:CMSOmniAccountDetails")
		.outType(CMSOmniAccountDetails.class);
		
		onException(Exception.class)
		.to("bean:oUtils?method=onException(${exchange},\"CMSOmniAccountDetailsResponse\",${header.system})")
		.handled(true);
		
		JaxbDataFormat getProcessRequest = new JaxbDataFormat();
		JAXBContext jaxconReq = JAXBContext.newInstance(ProcessRequest.class);
		getProcessRequest.setContext(jaxconReq);
		
		from("direct:CMSOmniAccountDetails").routeId("CMSOmniAccountDetails")
		.streamCaching()
		.setHeader("system", constant("MW"))
		
		.to("bean:CMSOmniAccountDetailsService?method=setOmniAccountDetailsRequestIn")
		.to("bean:CMSOmniAccountDetailsService?method=processRequest")
		
		.marshal(getProcessRequest)
		
		.log("${body}")
		.to("{{UDDIConnector.host}}{{UDDIConnector.contextPath}}"+"/cms/v1/ProcessRequest?bridgeEndpoint=true")
		
		.choice()
			.when().simple("${body} != null")
//			.when(xpath("/Envelope/Body/processRequestResponse/return[contains(text(), 'OMNIDATA') and contains(text(), 'INSTCODE%3A%22NCB%22')]"))
				.to("bean:CMSOmniAccountDetailsService?method=prepareXMLResponse")
				.setHeader("Content-Type",constant("application/json"))
			.otherwise()
					.to("bean:oUtils?method=prepareFaultNodeStr(\"CMSOmniAccountDetailsResponse\",\"RECORDNOTFOUND\",\"\",\"\",\"\",\"sysOrAppWithoutBkndError\",${exchange})")
		.endChoice();
		
	}
}
