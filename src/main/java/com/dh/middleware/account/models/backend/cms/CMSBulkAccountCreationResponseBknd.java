
package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "success",
    "fault"
})
@XmlRootElement(name = "CMSBulkAccountCreationResponse")
public class CMSBulkAccountCreationResponseBknd {

	@XmlElement(name = "success")
    protected CMSAccountListType success;

//    @XmlElement(namespace = "http://corp.alahli.com/middlewareservices/fault/1.0/")
//    protected FaultType fault;

    /**
     * Gets the value of the success property.
     * 
     * @return
     *     possible object is
     *     {@link CMSAccountListType }
     *     
     */
    public CMSAccountListType getSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     * @param value
     *     allowed object is
     *     {@link CMSAccountListType }
     *     
     */
    public void setSuccess(CMSAccountListType value) {
        this.success = value;
    }

    @Override
	public String toString() {
		return "CMSBulkAccountCreationResponseBknd [success=" + success + "]";
	}
   
}
