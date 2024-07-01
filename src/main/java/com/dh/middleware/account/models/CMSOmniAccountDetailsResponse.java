
package com.dh.middleware.account.models;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success"
})
@XmlRootElement(name = "CMSOmniAccountDetailsResponse")
public class CMSOmniAccountDetailsResponse {

    protected CMSOmniAccountDetailsResponseType success;
//    @XmlElement(namespace = "http://corp.alahli.com/middlewareservices/fault/1.0/")
//    protected FaultType fault;

    public CMSOmniAccountDetailsResponseType getSuccess() {
        return success;
    }

    public void setSuccess(CMSOmniAccountDetailsResponseType value) {
        this.success = value;
    }

	@Override
	public String toString() {
		return "CMSOmniAccountDetailsResponse [success=" + success + "]";
	}

    

//    public FaultType getFault() {
//        return fault;
//    }

//    public void setFault(FaultType value) {
//        this.fault = value;
//    }

}
