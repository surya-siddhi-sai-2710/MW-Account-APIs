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

import com.dh.middleware.account.models.AmendmentPayrollDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@UseAdviceWith
@CamelSpringBootTest
@SpringBootApplication
@WebAppConfiguration

@MockEndpointsAndSkip("http:localhost:8081/api/connector/configstore")

@ImportResource({ "classpath:spring/camel-context.xml" })
@PropertySource("classpath:application-test.properties")
@Configuration
@ComponentScan("com.dh.middleware.account.*")
public class AmendPayrollDetailsRouteTest {

	@Autowired
	CamelContext camelContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProducerTemplate producerTemplate;
	
	@EndpointInject("mock://http:localhost:8088/api/connector/db/bancsdb/v1/AmendPayrollDetails")
	private MockEndpoint cdmockEndpoint;

	@EndpointInject("mock://http:localhost:8081/api/connector/configstore")
	private MockEndpoint configStore;
	
	@Test
	public void inquirePayrollDetailsRouteSuccessTest() throws Exception {
		
		String inquirePayrollDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/AmendPayrollDetails/InquirePayrollDetails/SuccessRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String inquirePayrollDetailsResponse = Resources.toString(
				Resources.getResource("mock/backend/AmendPayrollDetails/InquirePayrollDetails/SuccessResponse.json"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "AmendPayrollDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:getAmendPayrollDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(inquirePayrollDetailsResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();

		AmendmentPayrollDetails oInquirePayrollDetailsRequest = objectMapper.readValue(inquirePayrollDetailsRequest, AmendmentPayrollDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"tellerId\": \"T123\", \"branchId\": \"B001\",\"channelId\": \"WEB\"}");

		AmendmentPayrollDetails successResponse = producerTemplate.requestBodyAndHeaders("direct:getAmendPayrollDetails", oInquirePayrollDetailsRequest,  headers, AmendmentPayrollDetails.class);

		System.out.println("PayrollDetailsAmendmentResponse " + successResponse.getPayrollDetailsAmendmentResponse().getSuccess().getAccountId());

		Assertions.assertNotNull(successResponse.getPayrollDetailsAmendmentResponse().getSuccess().getAccountId());
		
	}
	
	@Test
	public void inquirePayrollDetailsRouteFaultTest() throws Exception {
		
		String inquirePayrollDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/AmendPayrollDetails/InquirePayrollDetails/FaultRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_SystemErrors.json"),
				Charsets.UTF_8);

		String inquirePayrollDetailsResponse = Resources.toString(
				Resources.getResource("mock/backend/AmendPayrollDetails/InquirePayrollDetails/FaultResponse.json"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "AmendPayrollDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:getAmendPayrollDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(inquirePayrollDetailsResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();

		AmendmentPayrollDetails oInquirePayrollDetailsRequest = objectMapper.readValue(inquirePayrollDetailsRequest, AmendmentPayrollDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"tellerId\": \"T123\", \"branchId\": \"B001\",\"channelId\": \"WEB\"}");

		String faultResponse = producerTemplate.requestBodyAndHeaders("direct:getAmendPayrollDetails", oInquirePayrollDetailsRequest,  headers, String.class);

		System.out.println("Fault response: " + faultResponse);

		Assertions.assertNotNull(faultResponse.contains("BANCSDB"));
	}
	
	@Test
	public void updatePayrollDetailsRouteSuccessTest() throws Exception {
		
		String inquirePayrollDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/AmendPayrollDetails/UpdatePayrollDetails/SuccessRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String inquirePayrollDetailsResponse = Resources.toString(
				Resources.getResource("mock/backend/AmendPayrollDetails/UpdatePayrollDetails/SuccessResponse.json"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "AmendPayrollDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:getAmendPayrollDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(inquirePayrollDetailsResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();

		AmendmentPayrollDetails oInquirePayrollDetailsRequest = objectMapper.readValue(inquirePayrollDetailsRequest, AmendmentPayrollDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"tellerId\": \"T123\", \"branchId\": \"B001\",\"channelId\": \"WEB\"}");

		AmendmentPayrollDetails successResponse = producerTemplate.requestBodyAndHeaders("direct:getAmendPayrollDetails", oInquirePayrollDetailsRequest,  headers, AmendmentPayrollDetails.class);

		System.out.println("PayrollDetailsAmendmentResponse " + successResponse.getPayrollDetailsAmendmentResponse().getSuccess());

		Assertions.assertNotNull(successResponse.getPayrollDetailsAmendmentResponse().getSuccess());
		
	}
	
	@Test
	public void updatePayrollDetailsRouteFaultTest() throws Exception {
		
		String inquirePayrollDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/AmendPayrollDetails/UpdatePayrollDetails/FaultRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_SystemErrors.json"),
				Charsets.UTF_8);

		String inquirePayrollDetailsResponse = Resources.toString(
				Resources.getResource("mock/backend/AmendPayrollDetails/UpdatePayrollDetails/FaultResponse.json"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "AmendPayrollDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:getAmendPayrollDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(inquirePayrollDetailsResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();

		AmendmentPayrollDetails oInquirePayrollDetailsRequest = objectMapper.readValue(inquirePayrollDetailsRequest, AmendmentPayrollDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"tellerId\": \"T123\", \"branchId\": \"B001\",\"channelId\": \"WEB\"}");

		String faultResponse = producerTemplate.requestBodyAndHeaders("direct:getAmendPayrollDetails", oInquirePayrollDetailsRequest,  headers, String.class);

		System.out.println("Fault response: " + faultResponse);

		Assertions.assertNotNull(faultResponse.contains("BANCSDB"));
	}
	
	@Test
	public void modeValidationPayrollDetailsRouteFaultTest() throws Exception {
		
		String inquirePayrollDetailsRequest = Resources.toString(
				Resources.getResource("mock/frontend/AmendPayrollDetails/FaultRequest.json"), Charsets.UTF_8);

		String ApplicationErrorConfigStore = Resources.toString(
				Resources.getResource("mock/backend/configStore/ConfigStoreResponse_Errors_ApplicationErrors.json"),
				Charsets.UTF_8);

		String inquirePayrollDetailsResponse = Resources.toString(
				Resources.getResource("mock/backend/AmendPayrollDetails/FaultResponse.json"), Charsets.UTF_8);

		AdviceWith.adviceWith(camelContext, "AmendPayrollDetails", routeBuilder ->

		{
			routeBuilder.replaceFromWith("direct:getAmendPayrollDetails");
		});
		
		cdmockEndpoint.expectedMessageCount(1);
		cdmockEndpoint.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(inquirePayrollDetailsResponse);
			}
		});

		configStore.expectedMessageCount(1);
		configStore.whenAnyExchangeReceived(new Processor() {
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(ApplicationErrorConfigStore);
			}
		});
		
		camelContext.start();

		AmendmentPayrollDetails oInquirePayrollDetailsRequest = objectMapper.readValue(inquirePayrollDetailsRequest, AmendmentPayrollDetails.class);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("ServiceHeader", "{  \"tellerId\": \"T123\", \"branchId\": \"B001\",\"channelId\": \"WEB\"}");

		String faultResponse = producerTemplate.requestBodyAndHeaders("direct:getAmendPayrollDetails", oInquirePayrollDetailsRequest,  headers, String.class);

		System.out.println("Fault response: " + faultResponse);

		Assertions.assertNotNull(faultResponse.contains("Mandatory Value is missing"));
	}
}
