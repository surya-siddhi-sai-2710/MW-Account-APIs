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
import com.dh.middleware.account.models.CMSOmniAccountDetails;
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

public class CMSOmniAccountDetailsRouteTest {

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
	public void cMSOmniAccountDetailsSuccessTest() throws Exception {

		String getCMSOmniAccountRequest = Resources.toString(
				Resources.getResource("mock/frontend/CMSOmniAccountDetails/CMSOmniAccountDetailsSuccessRequest.json"),
				Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String getCMSOmniAccountResponse = Resources.toString(
				Resources.getResource("mock/backend/CMSOmniAccountDetails/CMSOmniAccountDetailsSuccessResponse.xml"),
				Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "CMSOmniAccountDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:CMSOmniAccountDetails");
		});

		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getCMSOmniAccountResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});

		camelContext.start();

		CMSOmniAccountDetails oCMSOmniAccountDetailsRequest = objectMapper.readValue(getCMSOmniAccountRequest,
				CMSOmniAccountDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader",
				"{  \"channelId\": \"800\", \"languageCode\": \"en_US\",\"authenticationType\": \"OTP\"}");

		CMSOmniAccountDetails successResponse = producerTemplate.requestBodyAndHeaders("direct:CMSOmniAccountDetails",
				oCMSOmniAccountDetailsRequest, headers, CMSOmniAccountDetails.class);

		System.out.println("CMSOmniAccountDetailsResponse "
				+ successResponse.getAccountDetailsResponse().getSuccess().getAccount().get(0).getAccountOwnerType());

		Assertions.assertNotNull(
				successResponse.getAccountDetailsResponse().getSuccess().getAccount().get(0).getAccountOwnerType());
	}

	@Test
	public void cMSOmniAccountDetailsFaultTest() throws Exception {

		String getCMSOmniAccountRequest = Resources.toString(
				Resources.getResource("mock/frontend/CMSOmniAccountDetails/CMSOmniAccountDetailsFaultRequest.json"),
				Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String getCMSOmniAccountResponse = Resources.toString(
				Resources.getResource("mock/backend/CMSOmniAccountDetails/CMSOmniAccountDetailsFaultResponse.xml"),
				Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "CMSOmniAccountDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:CMSOmniAccountDetails");
		});

		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(getCMSOmniAccountResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});

		camelContext.start();

		CMSOmniAccountDetails oCMSOmniAccountDetailsRequest = objectMapper.readValue(getCMSOmniAccountRequest,
				CMSOmniAccountDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader",
				"{  \"channelId\": \"800\", \"languageCode\": \"en_US\",\"authenticationType\": \"OTP\"}");

		String faultResponse = producerTemplate.requestBodyAndHeaders("direct:CMSOmniAccountDetails",
				oCMSOmniAccountDetailsRequest, headers, String.class);

		System.out.println("CMSOmniAccountDetailsResponse " + faultResponse);

		Assertions.assertNotNull(faultResponse.contains("fault"));
	}
}
