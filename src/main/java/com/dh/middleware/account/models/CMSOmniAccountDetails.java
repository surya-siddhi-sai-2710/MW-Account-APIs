package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CMSAccountsRequest",
    "CMSOmniAccountDetailsResponse"
})
public class CMSOmniAccountDetails {

	@JsonProperty("CMSAccountsRequest")
	private CMSOmniAccountDetailsRequest accountDetailsRequest;

	@JsonProperty("CMSOmniAccountDetailsResponse")
	private CMSOmniAccountDetailsResponse accountDetailsResponse;

	public CMSOmniAccountDetailsRequest getAccountDetailsRequest() {
		return accountDetailsRequest;
	}

	public void setAccountDetailsRequest(CMSOmniAccountDetailsRequest accountDetailsRequest) {
		this.accountDetailsRequest = accountDetailsRequest;
	}

	public CMSOmniAccountDetailsResponse getAccountDetailsResponse() {
		return accountDetailsResponse;
	}

	public void setAccountDetailsResponse(CMSOmniAccountDetailsResponse accountDetailsResponse) {
		this.accountDetailsResponse = accountDetailsResponse;
	}
	
	@Override
	public String toString() {
		
		if (accountDetailsRequest == null) {
            return "{\"CMSAccountsRequest\": null}";
        }
		
		return "{" + "\"CMSAccountsRequest\": {" + "\"omniAccountNumber\": \"" + accountDetailsRequest.getOmniAccountNumber()
				+ "\"," + "\"cifNumber\": \"" + accountDetailsRequest.getCifNumber() + "\","
				+ "\"transactionNotificationFlag\": \"" + accountDetailsRequest.getTransactionNotificationFlag()
				+ "\"" + "}" + "}";
		
	}

}
