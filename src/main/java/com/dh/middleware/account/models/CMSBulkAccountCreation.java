package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CMSBulkAccountCreationRequest",
    "CMSBulkAccountCreationRequest"
})
public class CMSBulkAccountCreation {

	@JsonProperty("CMSBulkAccountCreationRequest")
	private CMSBulkAccountCreationRequest accountCreationRequest;
	
	@JsonProperty("CMSBulkAccountCreationResponse")
	private CMSBulkAccountCreationResponse accountCreationResponse;

	public CMSBulkAccountCreationRequest getAccountCreationRequest() {
		return accountCreationRequest;
	}

	public void setAccountCreationRequest(CMSBulkAccountCreationRequest accountCreationRequest) {
		this.accountCreationRequest = accountCreationRequest;
	}

	public CMSBulkAccountCreationResponse getAccountCreationResponse() {
		return accountCreationResponse;
	}

	public void setAccountCreationResponse(CMSBulkAccountCreationResponse accountCreationResponse) {
		this.accountCreationResponse = accountCreationResponse;
	}

	@Override
	public String toString() {
		return "CMSBulkAccountCreation [accountCreationRequest=" + accountCreationRequest + ", accountCreationResponse="
				+ accountCreationResponse + "]";
	}
	
	
}
