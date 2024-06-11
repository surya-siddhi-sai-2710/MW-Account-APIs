
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success"
})

public class CMSBulkAccountCreationResponse {

	@JsonProperty("success")
    protected CreatedCMSAccountListType success;

    /**
     * Gets the value of the success property.
     * 
     * @return
     *     possible object is
     *     {@link CreatedCMSAccountListType }
     *     
     */
    public CreatedCMSAccountListType getSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatedCMSAccountListType }
     *     
     */
    public void setSuccess(CreatedCMSAccountListType value) {
        this.success = value;
    }

	@Override
	public String toString() {
		return "CMSBulkAccountCreationResponse [success=" + success + "]";
	}

    
}
