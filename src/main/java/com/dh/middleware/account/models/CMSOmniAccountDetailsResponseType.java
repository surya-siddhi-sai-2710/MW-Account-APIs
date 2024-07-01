
package com.dh.middleware.account.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "statusCode",
    "statusDescription",
    "notes",
    "account"
})
public class CMSOmniAccountDetailsResponseType {

    public void setAccount(List<CMSOmniAccountDetailsType> account) {
		this.account = account;
	}


	protected String statusCode;
    protected String statusDescription;
    protected String notes;
    protected List<CMSOmniAccountDetailsType> account;

    public String getStatusCode() {
        return statusCode;
    }


    public void setStatusCode(String value) {
        this.statusCode = value;
    }


    public String getStatusDescription() {
        return statusDescription;
    }


    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    public String getNotes() {
        return notes;
    }


    public void setNotes(String value) {
        this.notes = value;
    }

    
    public List<CMSOmniAccountDetailsType> getAccount() {
        if (account == null) {
            account = new ArrayList<CMSOmniAccountDetailsType>();
        }
        return this.account;
    }


	@Override
	public String toString() {
		return "CMSOmniAccountDetailsResponseType [statusCode=" + statusCode + ", statusDescription="
				+ statusDescription + ", notes=" + notes + ", account=" + account + "]";
	}

    
}
