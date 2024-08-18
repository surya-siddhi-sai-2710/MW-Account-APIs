package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmendmentPayrollDetails {

	@JsonProperty("PayrollDetailsAmendmentRequest")
	private PayrollDetailsAmendmentRequest payrollDetailsAmendmentRequest;
	
	@JsonProperty("PayrollDetailsAmendmentResponse")
	private PayrollDetailsAmendmentResponse payrollDetailsAmendmentResponse;

	public PayrollDetailsAmendmentRequest getPayrollDetailsAmendmentRequest() {
		return payrollDetailsAmendmentRequest;
	}

	public void setPayrollDetailsAmendmentRequest(PayrollDetailsAmendmentRequest payrollDetailsAmendmentRequest) {
		this.payrollDetailsAmendmentRequest = payrollDetailsAmendmentRequest;
	}

	public PayrollDetailsAmendmentResponse getPayrollDetailsAmendmentResponse() {
		return payrollDetailsAmendmentResponse;
	}

	public void setPayrollDetailsAmendmentResponse(PayrollDetailsAmendmentResponse payrollDetailsAmendmentResponse) {
		this.payrollDetailsAmendmentResponse = payrollDetailsAmendmentResponse;
	}

	@Override
	public String toString() {
		return "PayrollDetailsAmendment [payrollDetailsAmendmentRequest=" + payrollDetailsAmendmentRequest
				+ ", payrollDetailsAmendmentResponse=" + payrollDetailsAmendmentResponse + "]";
	}
	
	
}
