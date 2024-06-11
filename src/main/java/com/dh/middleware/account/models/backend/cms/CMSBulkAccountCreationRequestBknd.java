
package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
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
@XmlRootElement(name = "CMSBulkAccountCreationRequest")
public class CMSBulkAccountCreationRequestBknd {

	@XmlElement(name = "omniMappedCode")
    protected String omniMappedCode;
	
	@XmlElement(name = "bulkCount")
    protected int bulkCount;
	
	@XmlElement(name = "omniEnglishName")
    protected String omniEnglishName;
	
	@XmlElement(name = "omniArabicName")
    protected String omniArabicName;
	
	@XmlElement(name = "currency")
    protected String currency;
	
	@XmlElement(name = "omniAccountNumber")
    protected String omniAccountNumber;
	
	@XmlElement(name = "remitterIdFrom")
    protected String remitterIdFrom;
	
	@XmlElement(name = "remitterIdTo")
    protected String remitterIdTo;
	
	@XmlElement(name = "blockedTransactions")
    protected String blockedTransactions;
	
	@XmlElement(name = "userComments")
    protected String userComments;
	
	@XmlElement(name = "transactionNotificationFlag")
    protected String transactionNotificationFlag;
	
	@XmlElement(name = "debitCreditFlag")
    protected String debitCreditFlag;
    
	@XmlElement(name = "minimumAccountBalanceLimit")
    protected String minimumAccountBalanceLimit;
	
	@XmlElement(name = "maximumAccountBalanceLimit")
    protected String maximumAccountBalanceLimit;
	
	@XmlElement(name = "subscriptionFlag")
    protected String subscriptionFlag;
	
	@XmlElement(name = "accountResetFlag")
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

}
