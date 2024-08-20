package com.dh.middleware.account.bean;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alahli.middleware.utility.Utils.StringUtil;
import com.alahli.middleware.utility.Utils.Utils;
import com.dh.middleware.account.models.AmendmentPayrollDetails;
import com.dh.middleware.account.models.PayrollDetailsAmendmentRequest;
import com.dh.middleware.account.models.PayrollDetailsAmendmentResponse;
import com.dh.middleware.account.models.ServiceHeader;
import com.dh.middleware.account.models.Success;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentRequestTypeBknd;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentResponseTypeBknd;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentResponseBknd;
import com.dh.middleware.account.models.backends.bancs.PayrollDetailsAmendmentRequestBknd;
import com.dh.middleware.account.models.backends.bancs.UpdatePayrollDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AmendPayrollDetailsService {

	@Autowired
	Utils oUtils;

	@Autowired
	StringUtil oStringUtil;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private ServiceHeader oServiceHeader;
	
	private AmendmentPayrollDetails oPayrollDetailsAmendment;
	
	private PayrollDetailsAmendmentRequest oPayrollDetailsAmendmentRequest;
	

	public AmendmentPayrollDetails getPayrollDetailsAmendment() {
		return oPayrollDetailsAmendment;
	}

	public void setPayrollDetailsAmendment(AmendmentPayrollDetails payrollDetailsAmendment) {
		this.oPayrollDetailsAmendment = payrollDetailsAmendment;
	}

	public PayrollDetailsAmendmentRequest getPayrollDetailsAmendmentRequest() {
		return oPayrollDetailsAmendmentRequest;
	}

	public void setPayrollDetailsAmendmentRequest(PayrollDetailsAmendmentRequest payrollDetailsAmendmentRequest) {
		this.oPayrollDetailsAmendmentRequest = payrollDetailsAmendmentRequest;
	}
	
	
	public void getPayrollDetailsAmendmentRequestIn(AmendmentPayrollDetails detailsAmendment,
			@Header("ServiceHeader") String serviceHeader) throws JsonMappingException, JsonProcessingException {
		
		this.oServiceHeader = objectMapper.readValue(serviceHeader, ServiceHeader.class);
		this.oPayrollDetailsAmendment = detailsAmendment;
		this.oPayrollDetailsAmendmentRequest = detailsAmendment.getPayrollDetailsAmendmentRequest();
	}

	
	public PayrollDetailsAmendmentRequestBknd prepareInquirePayrollDetails(Exchange ex) throws Exception{
		
		PayrollDetailsAmendmentRequestBknd oPayrollDetailsAmendmentRequestBknd = new PayrollDetailsAmendmentRequestBknd();
		
		PayrollDetailsAmendmentRequestTypeBknd oPayrollDetailsAmendmentRequestTypeBknd = new PayrollDetailsAmendmentRequestTypeBknd();
		
		oPayrollDetailsAmendmentRequestTypeBknd.setAcctNum(oPayrollDetailsAmendmentRequest.getAccountId());

		oPayrollDetailsAmendmentRequestBknd.setoPayrollDetailsAmendmentRequestTypeBknd(oPayrollDetailsAmendmentRequestTypeBknd);
		
		return oPayrollDetailsAmendmentRequestBknd;
	}
	
	public AmendmentPayrollDetails prepareInquirePayrollResponse(@Body JsonNode body, Exchange ex) throws Exception{
		
		JsonNode InquirePayrollDetailsNode = body.get("PayrollDetailsAmendmentResponse");
		
		PayrollDetailsAmendmentResponseBknd oInquirePayrollDetails = new PayrollDetailsAmendmentResponseBknd();
		
		PayrollDetailsAmendmentResponseTypeBknd oTransaction = new PayrollDetailsAmendmentResponseTypeBknd();
		
		oTransaction.setAcctNum(InquirePayrollDetailsNode.get("ACCOUNTID").asText());
		oTransaction.setPayrollFlagInd(InquirePayrollDetailsNode.get("PAYROLLFLAGINDICATOR").asText());
		oTransaction.setSplAcctInd(InquirePayrollDetailsNode.get("SPECIALACCOUNTINDICATOR").asText());
		oTransaction.setPayrollReleInd(InquirePayrollDetailsNode.get("PAYROLLRELEASEINDICATOR").asText());
		oTransaction.setExpDt(InquirePayrollDetailsNode.get("PAYROLLEXPIRYDATE").asText());
		oTransaction.setIssueDt(InquirePayrollDetailsNode.get("PAYROLLISSUEDATE").asText());
		oTransaction.setSiebalReqNo(InquirePayrollDetailsNode.get("SIEBALREQUESTNUMBER").asText());
		
		oInquirePayrollDetails.setTransaction(oTransaction);
		
		AmendmentPayrollDetails amendmentPayrollDetails = new AmendmentPayrollDetails();
		
		PayrollDetailsAmendmentResponse amendmentResponse = new PayrollDetailsAmendmentResponse();
		Success success = new Success();
		
		success.setAccountId(oInquirePayrollDetails.getTransaction().getAcctNum());
		success.setPayrollFlagIndicator(oInquirePayrollDetails.getTransaction().getPayrollFlagInd());
		success.setSpecialAccountIndicator(oInquirePayrollDetails.getTransaction().getSplAcctInd());
		success.setPayrollReleaseIndicator(oInquirePayrollDetails.getTransaction().getPayrollReleInd());
		success.setPayrollExpiryDate(oInquirePayrollDetails.getTransaction().getExpDt());
		success.setPayrollIssueDate(oInquirePayrollDetails.getTransaction().getIssueDt());
		success.setSiebalRequestNumber(oInquirePayrollDetails.getTransaction().getSiebalReqNo());
		
		amendmentResponse.setSuccess(success);
		amendmentPayrollDetails.setPayrollDetailsAmendmentResponse(amendmentResponse);
		
		return amendmentPayrollDetails;
		
	}
	
//	public  AmendmentPayrollDetails prepareInquirePayrollDetailsResponse(PayrollDetailsAmendmentResponseBknd response) throws Exception{
//		
//		
//
//		
//	}
	
	public UpdatePayrollDetails prepareUpdatePayrollDetails(Exchange ex) throws Exception{
		
		UpdatePayrollDetails updatePayrollDetails = new UpdatePayrollDetails();
		
		PayrollDetailsAmendmentRequestTypeBknd transaction = new PayrollDetailsAmendmentRequestTypeBknd();
		
		transaction.setAcctNum(oPayrollDetailsAmendmentRequest.getAccountId());
		transaction.setPayrollFlagInd(oPayrollDetailsAmendmentRequest.getPayrollFlagIndicator());
		transaction.setSplAcctInd(oPayrollDetailsAmendmentRequest.getSpecialAccountIndicator());
		transaction.setPayrollReleInd(oPayrollDetailsAmendmentRequest.getPayrollReleaseIndicator());
		transaction.setExpDt(oPayrollDetailsAmendmentRequest.getPayrollExpiryDate());
		transaction.setIssueDt(oPayrollDetailsAmendmentRequest.getPayrollIssueDate());
		transaction.setSiebalReqNo(oPayrollDetailsAmendmentRequest.getSiebalRequestNumber());
		
		updatePayrollDetails.setTransaction(transaction);
		return updatePayrollDetails;
		
	}
	
	public AmendmentPayrollDetails prepareUpdatePayrollDetailsResponse(Exchange ex) throws Exception{
		
		AmendmentPayrollDetails amendmentPayrollDetails = new AmendmentPayrollDetails();
		
		PayrollDetailsAmendmentResponse amendmentResponse = new PayrollDetailsAmendmentResponse();
		Success success = new Success();
		
		
		amendmentResponse.setSuccess(success);
		amendmentPayrollDetails.setPayrollDetailsAmendmentResponse(amendmentResponse);
		
		return amendmentPayrollDetails;

		
	}
	
	
	
}
