
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "omniAccountNumber", "cifNumber", "transactionNotificationFlag" })

public class CMSOmniAccountDetailsRequest {

	protected String omniAccountNumber;
	protected String cifNumber;
	protected String transactionNotificationFlag;

	public String getOmniAccountNumber() {
		return omniAccountNumber;
	}

	public void setOmniAccountNumber(String value) {
		this.omniAccountNumber = value;
	}

	public String getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(String value) {
		this.cifNumber = value;
	}

	public String getTransactionNotificationFlag() {
		return transactionNotificationFlag;
	}

	public void setTransactionNotificationFlag(String value) {
		this.transactionNotificationFlag = value;
	}

	@Override
	public String toString() {
		return "CMSOmniAccountDetailsRequest [omniAccountNumber=" + omniAccountNumber + ", cifNumber=" + cifNumber
				+ ", transactionNotificationFlag=" + transactionNotificationFlag + "]";
	}

}
