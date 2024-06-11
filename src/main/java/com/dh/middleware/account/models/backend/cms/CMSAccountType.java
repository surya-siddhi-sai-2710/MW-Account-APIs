
package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatedCMSAccountType", propOrder = {

})
public class CMSAccountType {

	@XmlElement(name="accountNumber")
    protected String accountNumber;
	
	@XmlElement(name="ibanAccountNumber")
    protected String ibanAccountNumber;
	
	@XmlElement(name="remitterId")
    protected String remitterId;
	
	@XmlElement(name="transactionNotificationFlag")
    protected String transactionNotificationFlag;
	
	@XmlElement(name="debitCreditFlag")
    protected String debitCreditFlag;
	
	@XmlElement(name="minimumAccountBalanceLimit")
    protected String minimumAccountBalanceLimit;
	
	@XmlElement(name="maximumAccountBalanceLimit")
    protected String maximumAccountBalanceLimit;
	
	@XmlElement(name="subscriptionFlag")
    protected String subscriptionFlag;
	
	@XmlElement(name="accountResetFlag")
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
		return "CMSAccountType [accountNumber=" + accountNumber + ", ibanAccountNumber=" + ibanAccountNumber
				+ ", remitterId=" + remitterId + ", transactionNotificationFlag=" + transactionNotificationFlag
				+ ", debitCreditFlag=" + debitCreditFlag + ", minimumAccountBalanceLimit=" + minimumAccountBalanceLimit
				+ ", maximumAccountBalanceLimit=" + maximumAccountBalanceLimit + ", subscriptionFlag="
				+ subscriptionFlag + ", accountResetFlag=" + accountResetFlag + "]";
	}

    
}
