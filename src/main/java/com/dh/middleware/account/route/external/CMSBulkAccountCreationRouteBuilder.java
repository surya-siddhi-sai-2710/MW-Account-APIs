package com.dh.middleware.account.route.external;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.dh.middleware.account.models.CMSBulkAccountCreation;
import com.dh.middleware.account.models.backend.cms.ProcessRequest;

@Component
public class CMSBulkAccountCreationRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		.bindingMode(RestBindingMode.json);

		rest("/api/accounts")
		.post("/v1/CMSBulkAccountCreation")
		.type(CMSBulkAccountCreation.class)
		.consumes("application/json")
		.produces("application/json")
		.to("direct:CMSBulkAccountCreation")
		.outType(CMSBulkAccountCreation.class);
		
		onException(Exception.class)
		.to("bean:oUtils?method=onException(${exchange},\"CMSBulkAccountCreationResponse\",${header.system})")
		.handled(true);
		
		JaxbDataFormat getProcessRequest = new JaxbDataFormat();
		JAXBContext jaxconReq = JAXBContext.newInstance(ProcessRequest.class);
		getProcessRequest.setContext(jaxconReq);
		
		from("direct:CMSBulkAccountCreation").routeId("CMSBulkAccountCreation")
		.setHeader("system", constant("MW"))
		.to("bean:CMSBulkAccountCreationService?method=setCMSBulkAccountCreationRequestIn")
		.to("bean:CMSBulkAccountCreationService?method=prepareProcessRequest")
		
		.marshal(getProcessRequest)
		
		.setHeader("system", constant("CMS"))
		.setHeader("SOAPAction", constant("http://com.tcs.bancs.rm/processRequest"))
		.to("{{UDDIConnector.host}}{{UDDIConnector.contextPath}}/cms/v1/ProcessRequest?bridgeEndpoint=true")
		.to("bean:CMSBulkAccountCreationService?method=prepareXMLResponse")
		.setHeader("Content-Type",constant("application/json"));
		
	}
}
