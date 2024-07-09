
package com.dh.middleware.account.models;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "success" })
@XmlRootElement(name = "CMSOmniAccountDetailsResponse")
public class CMSOmniAccountDetailsResponse {

	protected CMSOmniAccountDetailsResponseType success;

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

}
