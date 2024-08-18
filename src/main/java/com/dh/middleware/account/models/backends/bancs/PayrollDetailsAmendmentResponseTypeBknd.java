package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayrollDetailsAmendmentResponseTypeBknd {

	@JsonProperty("acctNum")
	protected String acctNum;
	
	@JsonProperty("payrollFlagInd")
	protected String payrollFlagInd;
	
	@JsonProperty("splAcctInd")
	protected String splAcctInd;
	
	@JsonProperty("payrollReleInd")
	protected String payrollReleInd;
	
	@JsonProperty("expDt")
	protected String expDt;
	
	@JsonProperty("issueDt")
	protected String issueDt;
	
	@JsonProperty("siebalReqNo")
	protected String siebalReqNo;

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getPayrollFlagInd() {
		return payrollFlagInd;
	}

	public void setPayrollFlagInd(String payrollFlagInd) {
		this.payrollFlagInd = payrollFlagInd;
	}

	public String getSplAcctInd() {
		return splAcctInd;
	}

	public void setSplAcctInd(String splAcctInd) {
		this.splAcctInd = splAcctInd;
	}

	public String getPayrollReleInd() {
		return payrollReleInd;
	}

	public void setPayrollReleInd(String payrollReleInd) {
		this.payrollReleInd = payrollReleInd;
	}

	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

	public String getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}

	public String getSiebalReqNo() {
		return siebalReqNo;
	}

	public void setSiebalReqNo(String siebalReqNo) {
		this.siebalReqNo = siebalReqNo;
	}

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentResponseType [acctNum=" + acctNum + ", payrollFlagInd=" + payrollFlagInd
				+ ", splAcctInd=" + splAcctInd + ", payrollReleInd=" + payrollReleInd + ", expDt=" + expDt
				+ ", issueDt=" + issueDt + ", siebalReqNo=" + siebalReqNo + "]";
	}
	
	
}
