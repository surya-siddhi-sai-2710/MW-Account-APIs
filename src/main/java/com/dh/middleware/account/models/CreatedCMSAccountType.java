
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
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
	

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the ibanAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIbanAccountNumber() {
        return ibanAccountNumber;
    }

    /**
     * Sets the value of the ibanAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIbanAccountNumber(String value) {
        this.ibanAccountNumber = value;
    }

    /**
     * Gets the value of the remitterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemitterId() {
        return remitterId;
    }

    /**
     * Sets the value of the remitterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemitterId(String value) {
        this.remitterId = value;
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
		return "CreatedCMSAccountType [accountNumber=" + accountNumber + ", ibanAccountNumber=" + ibanAccountNumber
				+ ", remitterId=" + remitterId + ", transactionNotificationFlag=" + transactionNotificationFlag
				+ ", debitCreditFlag=" + debitCreditFlag + ", minimumAccountBalanceLimit=" + minimumAccountBalanceLimit
				+ ", maximumAccountBalanceLimit=" + maximumAccountBalanceLimit + ", subscriptionFlag="
				+ subscriptionFlag + ", accountResetFlag=" + accountResetFlag + "]";
	}

    
}
