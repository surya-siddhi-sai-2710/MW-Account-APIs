
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountId",
    "operationMode",
    "payrollFlagIndicator",
    "specialAccountIndicator",
    "payrollReleaseIndicator",
    "payrollExpiryDate",
    "payrollIssueDate",
    "siebalRequestNumber"
})
public class PayrollDetailsAmendmentRequest {

	@JsonProperty("accountId")
	private String accountId;
	
	@JsonProperty("operationMode")
	private String operationMode;
	
	@JsonProperty("payrollFlagIndicator")
	private String payrollFlagIndicator;
	
	@JsonProperty("specialAccountIndicator")
	private String specialAccountIndicator;
	
	@JsonProperty("payrollReleaseIndicator")
	private String payrollReleaseIndicator;
	
	@JsonProperty("payrollExpiryDate")
	private String payrollExpiryDate;
	
	@JsonProperty("payrollIssueDate")
	private String payrollIssueDate;
	
	@JsonProperty("siebalRequestNumber")
	private String siebalRequestNumber;
	

	@JsonProperty("accountId")
	public String getAccountId() {
		return accountId;
	}

	@JsonProperty("accountId")
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@JsonProperty("operationMode")
	public String getOperationMode() {
		return operationMode;
	}

	@JsonProperty("operationMode")
	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}

	@JsonProperty("payrollFlagIndicator")
	public String getPayrollFlagIndicator() {
		return payrollFlagIndicator;
	}

	@JsonProperty("payrollFlagIndicator")
	public void setPayrollFlagIndicator(String payrollFlagIndicator) {
		this.payrollFlagIndicator = payrollFlagIndicator;
	}

	@JsonProperty("specialAccountIndicator")
	public String getSpecialAccountIndicator() {
		return specialAccountIndicator;
	}

	@JsonProperty("specialAccountIndicator")
	public void setSpecialAccountIndicator(String specialAccountIndicator) {
		this.specialAccountIndicator = specialAccountIndicator;
	}

	@JsonProperty("payrollReleaseIndicator")
	public String getPayrollReleaseIndicator() {
		return payrollReleaseIndicator;
	}

	@JsonProperty("payrollReleaseIndicator")
	public void setPayrollReleaseIndicator(String payrollReleaseIndicator) {
		this.payrollReleaseIndicator = payrollReleaseIndicator;
	}

	@JsonProperty("payrollExpiryDate")
	public String getPayrollExpiryDate() {
		return payrollExpiryDate;
	}

	@JsonProperty("payrollExpiryDate")
	public void setPayrollExpiryDate(String payrollExpiryDate) {
		this.payrollExpiryDate = payrollExpiryDate;
	}

	@JsonProperty("payrollIssueDate")
	public String getPayrollIssueDate() {
		return payrollIssueDate;
	}

	@JsonProperty("payrollIssueDate")
	public void setPayrollIssueDate(String payrollIssueDate) {
		this.payrollIssueDate = payrollIssueDate;
	}

	@JsonProperty("siebalRequestNumber")
	public String getSiebalRequestNumber() {
		return siebalRequestNumber;
	}

	@JsonProperty("siebalRequestNumber")
	public void setSiebalRequestNumber(String siebalRequestNumber) {
		this.siebalRequestNumber = siebalRequestNumber;
	}

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentRequest [accountId=" + accountId + ", operationMode=" + operationMode
				+ ", payrollFlagIndicator=" + payrollFlagIndicator + ", specialAccountIndicator="
				+ specialAccountIndicator + ", payrollReleaseIndicator=" + payrollReleaseIndicator
				+ ", payrollExpiryDate=" + payrollExpiryDate + ", payrollIssueDate=" + payrollIssueDate
				+ ", siebalRequestNumber=" + siebalRequestNumber + "]";
	}

}
