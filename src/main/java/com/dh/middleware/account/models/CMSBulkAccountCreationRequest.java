
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "omniMappedCode",
    "bulkCount",
    "omniEnglishName",
    "omniArabicName",
    "currency",
    "omniAccountNumber",
    "remitterIdFrom",
    "remitterIdTo",
    "blockedTransactions",
    "userComments",
    "transactionNotificationFlag",
    "debitCreditFlag",
    "minimumAccountBalanceLimit",
    "maximumAccountBalanceLimit",
    "subscriptionFlag",
    "accountResetFlag"
})

public class CMSBulkAccountCreationRequest {

	@JsonProperty("omniMappedCode")
    protected String omniMappedCode;
	
	@JsonProperty("bulkCount")
    protected int bulkCount;
	
	@JsonProperty("omniEnglishName")
    protected String omniEnglishName;
	
	@JsonProperty("omniArabicName")
    protected String omniArabicName;
	
	@JsonProperty("currency")
    protected String currency;
	
	@JsonProperty("omniAccountNumber")
    protected String omniAccountNumber;
	
	@JsonProperty("remitterIdFrom")
    protected String remitterIdFrom;
	
	@JsonProperty("remitterIdTo")
    protected String remitterIdTo;
	
	@JsonProperty("blockedTransactions")
    protected String blockedTransactions;
	
	@JsonProperty("userComments")
    protected String userComments;
	
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

    public String getOmniMappedCode() {
        return omniMappedCode;
    }

    public void setOmniMappedCode(String value) {
        this.omniMappedCode = value;
    }

    public int getBulkCount() {
        return bulkCount;
    }

    public void setBulkCount(int value) {
        this.bulkCount = value;
    }

    public String getOmniEnglishName() {
        return omniEnglishName;
    }

    public void setOmniEnglishName(String value) {
        this.omniEnglishName = value;
    }

    public String getOmniArabicName() {
        return omniArabicName;
    }

    public void setOmniArabicName(String value) {
        this.omniArabicName = value;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String value) {
        this.currency = value;
    }

    public String getOmniAccountNumber() {
        return omniAccountNumber;
    }

    public void setOmniAccountNumber(String value) {
        this.omniAccountNumber = value;
    }

    public String getRemitterIdFrom() {
        return remitterIdFrom;
    }

    public void setRemitterIdFrom(String value) {
        this.remitterIdFrom = value;
    }

    public String getRemitterIdTo() {
        return remitterIdTo;
    }

    public void setRemitterIdTo(String value) {
        this.remitterIdTo = value;
    }

    public String getBlockedTransactions() {
        return blockedTransactions;
    }


    public void setBlockedTransactions(String value) {
        this.blockedTransactions = value;
    }


    public String getUserComments() {
        return userComments;
    }


    public void setUserComments(String value) {
        this.userComments = value;
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

//	@Override
//	public String toString() {
//		return "CMSBulkAccountCreationRequest [omniMappedCode=" + omniMappedCode + ", bulkCount=" + bulkCount
//				+ ", omniEnglishName=" + omniEnglishName + ", omniArabicName=" + omniArabicName + ", currency="
//				+ currency + ", omniAccountNumber=" + omniAccountNumber + ", remitterIdFrom=" + remitterIdFrom
//				+ ", remitterIdTo=" + remitterIdTo + ", blockedTransactions=" + blockedTransactions + ", userComments="
//				+ userComments + ", transactionNotificationFlag=" + transactionNotificationFlag + ", debitCreditFlag="
//				+ debitCreditFlag + ", minimumAccountBalanceLimit=" + minimumAccountBalanceLimit
//				+ ", maximumAccountBalanceLimit=" + maximumAccountBalanceLimit + ", subscriptionFlag="
//				+ subscriptionFlag + ", accountResetFlag=" + accountResetFlag + "]";
//	}

    
}
