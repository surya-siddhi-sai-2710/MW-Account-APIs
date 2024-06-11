
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

    /**
     * Gets the value of the omniMappedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmniMappedCode() {
        return omniMappedCode;
    }

    /**
     * Sets the value of the omniMappedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmniMappedCode(String value) {
        this.omniMappedCode = value;
    }

    /**
     * Gets the value of the bulkCount property.
     * 
     */
    public int getBulkCount() {
        return bulkCount;
    }

    /**
     * Sets the value of the bulkCount property.
     * 
     */
    public void setBulkCount(int value) {
        this.bulkCount = value;
    }

    /**
     * Gets the value of the omniEnglishName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmniEnglishName() {
        return omniEnglishName;
    }

    /**
     * Sets the value of the omniEnglishName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmniEnglishName(String value) {
        this.omniEnglishName = value;
    }

    /**
     * Gets the value of the omniArabicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmniArabicName() {
        return omniArabicName;
    }

    /**
     * Sets the value of the omniArabicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmniArabicName(String value) {
        this.omniArabicName = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the omniAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmniAccountNumber() {
        return omniAccountNumber;
    }

    /**
     * Sets the value of the omniAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmniAccountNumber(String value) {
        this.omniAccountNumber = value;
    }

    /**
     * Gets the value of the remitterIdFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitterIdFrom() {
        return remitterIdFrom;
    }

    /**
     * Sets the value of the remitterIdFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitterIdFrom(String value) {
        this.remitterIdFrom = value;
    }

    /**
     * Gets the value of the remitterIdTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitterIdTo() {
        return remitterIdTo;
    }

    /**
     * Sets the value of the remitterIdTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitterIdTo(String value) {
        this.remitterIdTo = value;
    }

    /**
     * Gets the value of the blockedTransactions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockedTransactions() {
        return blockedTransactions;
    }

    /**
     * Sets the value of the blockedTransactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockedTransactions(String value) {
        this.blockedTransactions = value;
    }

    /**
     * Gets the value of the userComments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserComments() {
        return userComments;
    }

    /**
     * Sets the value of the userComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserComments(String value) {
        this.userComments = value;
    }

    /**
     * Gets the value of the transactionNotificationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNotificationFlag() {
        return transactionNotificationFlag;
    }

    /**
     * Sets the value of the transactionNotificationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNotificationFlag(String value) {
        this.transactionNotificationFlag = value;
    }

    /**
     * Gets the value of the debitCreditFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitCreditFlag() {
        return debitCreditFlag;
    }

    /**
     * Sets the value of the debitCreditFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitCreditFlag(String value) {
        this.debitCreditFlag = value;
    }

    /**
     * Gets the value of the minimumAccountBalanceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimumAccountBalanceLimit() {
        return minimumAccountBalanceLimit;
    }

    /**
     * Sets the value of the minimumAccountBalanceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimumAccountBalanceLimit(String value) {
        this.minimumAccountBalanceLimit = value;
    }

    /**
     * Gets the value of the maximumAccountBalanceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumAccountBalanceLimit() {
        return maximumAccountBalanceLimit;
    }

    /**
     * Sets the value of the maximumAccountBalanceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumAccountBalanceLimit(String value) {
        this.maximumAccountBalanceLimit = value;
    }

    /**
     * Gets the value of the subscriptionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionFlag() {
        return subscriptionFlag;
    }

    /**
     * Sets the value of the subscriptionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionFlag(String value) {
        this.subscriptionFlag = value;
    }

    /**
     * Gets the value of the accountResetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountResetFlag() {
        return accountResetFlag;
    }

    /**
     * Sets the value of the accountResetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountResetFlag(String value) {
        this.accountResetFlag = value;
    }

	@Override
	public String toString() {
		return "CMSBulkAccountCreationRequest [omniMappedCode=" + omniMappedCode + ", bulkCount=" + bulkCount
				+ ", omniEnglishName=" + omniEnglishName + ", omniArabicName=" + omniArabicName + ", currency="
				+ currency + ", omniAccountNumber=" + omniAccountNumber + ", remitterIdFrom=" + remitterIdFrom
				+ ", remitterIdTo=" + remitterIdTo + ", blockedTransactions=" + blockedTransactions + ", userComments="
				+ userComments + ", transactionNotificationFlag=" + transactionNotificationFlag + ", debitCreditFlag="
				+ debitCreditFlag + ", minimumAccountBalanceLimit=" + minimumAccountBalanceLimit
				+ ", maximumAccountBalanceLimit=" + maximumAccountBalanceLimit + ", subscriptionFlag="
				+ subscriptionFlag + ", accountResetFlag=" + accountResetFlag + "]";
	}

    
}
