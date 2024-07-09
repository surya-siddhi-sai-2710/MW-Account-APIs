
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedCMSAccountType {

	@JsonProperty("accountNumber")
	protected String accountNumber;

	@JsonProperty("ibanAccountNumber")
	protected String ibanAccountNumber;

	@JsonProperty("remitterId")
	protected String remitterId;

	@JsonProperty("transactionNotificationFlag")
	protected String transactionNotificationFlag;

	@JsonProperty("debitCreditFlag")
	protected String debitCreditFlag;

	@JsonProperty("minimumAccountBalanceLimit")
	protected String minimumAccountBalanceLimit;

	@JsonProperty("maximumAccountBalanceLimit")
	protected String maximumAccountBalanceLimit;

	@JsonProperty("subscriptionFlag")
	protected String subscriptionFlag;

	@JsonProperty("accountResetFlag")
	protected String accountResetFlag;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String value) {
		this.accountNumber = value;
	}

	public String getIbanAccountNumber() {
		return ibanAccountNumber;
	}

	public void setIbanAccountNumber(String value) {
		this.ibanAccountNumber = value;
	}

	public String getRemitterId() {
		return remitterId;
	}

	public void setRemitterId(String value) {
		this.remitterId = value;
	}

	public String getTransactionNotificationFlag() {
		return transactionNotificationFlag;
	}

	public void setTransactionNotificationFlag(String value) {
		this.transactionNotificationFlag = value;
	}

	public String getDebitCreditFlag() {
		return debitCreditFlag;
	}

	public void setDebitCreditFlag(String value) {
		this.debitCreditFlag = value;
	}

	public String getMinimumAccountBalanceLimit() {
		return minimumAccountBalanceLimit;
	}

	public void setMinimumAccountBalanceLimit(String value) {
		this.minimumAccountBalanceLimit = value;
	}

	public String getMaximumAccountBalanceLimit() {
		return maximumAccountBalanceLimit;
	}

	public void setMaximumAccountBalanceLimit(String value) {
		this.maximumAccountBalanceLimit = value;
	}

	public String getSubscriptionFlag() {
		return subscriptionFlag;
	}

	public void setSubscriptionFlag(String value) {
		this.subscriptionFlag = value;
	}

	public String getAccountResetFlag() {
		return accountResetFlag;
	}

	public void setAccountResetFlag(String value) {
		this.accountResetFlag = value;
	}

	@Override
	public String toString() {
		return "CreatedCMSAccountType [accountNumber=" + accountNumber + ", ibanAccountNumber=" + ibanAccountNumber
				+ ", remitterId=" + remitterId + ", transactionNotificationFlag=" + transactionNotificationFlag
				+ ", debitCreditFlag=" + debitCreditFlag + ", minimumAccountBalanceLimit=" + minimumAccountBalanceLimit
				+ ", maximumAccountBalanceLimit=" + maximumAccountBalanceLimit + ", subscriptionFlag="
				+ subscriptionFlag + ", accountResetFlag=" + accountResetFlag + "]";
	}

}
