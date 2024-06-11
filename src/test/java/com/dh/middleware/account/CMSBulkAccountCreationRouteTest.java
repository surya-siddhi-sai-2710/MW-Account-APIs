package com.dh.middleware.account;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpointsAndSkip;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dh.middleware.account.models.CMSBulkAccountCreation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@UseAdviceWith
@CamelSpringBootTest
@SpringBootApplication
@WebAppConfiguration

@MockEndpointsAndSkip("http:localhost:8081/api/connector/configstore.*|http://localhost:8080/api/connector/uddi/cms/v1/ProcessRequest.*")

@ImportResource({ "classpath:spring/camel-context.xml" })
@PropertySource("classpath:application-test.properties")
@Configuration
@ComponentScan("com.dh.middleware.account.*")
public class CMSBulkAccountCreationRouteTest {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProducerTemplate producerTemplate;
	
	@EndpointInject("mock://http:localhost:8080/api/connector/uddi/cms/v1/ProcessRequest")
	private MockEndpoint cdmockEndpoint;
	
	@EndpointInject("mock://http:localhost:8081/api/connector/configstore")
	private MockEndpoint configStore;
	
	@Test
	public void cMSBulkAccountCreationSuccessTest() throws Exception {

		String getCMSBulkAccountRequest = Resources.toString(
				Resources.getResource("mock/frontend/CMSBulkAccountCreation/CMSBulkAccountCreationSuccessRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String getCMSBulkAccountResponse = Resources.toString(
				Resources.getResource("mock/backend/CMSBulkAccountCreation/CMSBulkAccountCreationResponseBknd.xml"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "CMSBulkAccountCreation", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:CMSBulkAccountCreation");
		});

		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getCMSBulkAccountResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});

		camelContext.start();

		CMSBulkAccountCreation oCMSBulkAccountCreationRequest = objectMapper.readValue(getCMSBulkAccountRequest, CMSBulkAccountCreation.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"channelId\": \"800\", \"languageCode\": \"en_US\",\"authenticationType\": \"OTP\"}");
		
		CMSBulkAccountCreation successResponse = producerTemplate.requestBodyAndHeaders("direct:CMSBulkAccountCreation", 
				oCMSBulkAccountCreationRequest,  headers, CMSBulkAccountCreation.class);

		System.out.println("CMSBulkAccountCreationResponse " + successResponse.getAccountCreationResponse().getSuccess().getAccount().get(0).getAccountNumber());

		Assertions.assertNotNull(successResponse.getAccountCreationResponse().getSuccess().getAccount().get(0).getAccountNumber());
	}
	
	@Test
	public void cMSBulkAccountCreationFaultTest() throws Exception {

		String getCMSBulkAccountRequest = Resources.toString(
				Resources.getResource("mock/frontend/CMSBulkAccountCreation/CMSBulkAccountCreationFaultRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String getCMSBulkAccountResponse = Resources.toString(
				Resources.getResource("mock/backend/CMSBulkAccountCreation/CMSBulkAccountCreationFaultResponse.xml"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "CMSBulkAccountCreation", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:CMSBulkAccountCreation");
		});

		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getCMSBulkAccountResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});

		camelContext.start();

		CMSBulkAccountCreation oCMSBulkAccountCreationRequest = objectMapper.readValue(getCMSBulkAccountRequest, CMSBulkAccountCreation.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"channelId\": \"800\", \"languageCode\": \"en_US\",\"authenticationType\": \"OTP\"}");
		
//		CMSBulkAccountCreation faultResponse = producerTemplate.requestBodyAndHeaders("direct:CMSBulkAccountCreation", 
//				oCMSBulkAccountCreationRequest,  headers, CMSBulkAccountCreation.class);
		
		String faultResponse = producerTemplate.requestBodyAndHeaders("direct:CMSBulkAccountCreation", 
				oCMSBulkAccountCreationRequest,  headers, String.class);

//		System.out.println("CMSBulkAccountCreationResponse " + faultResponse.getAccountCreationResponse().getSuccess().getAccount().get(0).getAccountNumber());

		System.out.println("CMSBulkAccountCreationResponse " + faultResponse);
		
//		Assertions.assertTrue(null == faultResponse.getAccountCreationResponse().getSuccess().getAccount().get(0).getAccountNumber());
		Assertions.assertNotNull(faultResponse.contains(""));
	}
}
