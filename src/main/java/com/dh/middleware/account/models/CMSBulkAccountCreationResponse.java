
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

	public CreatedCMSAccountListType getSuccess() {
		return success;
	}

	public void setSuccess(CreatedCMSAccountListType value) {
		this.success = value;
	}

	@Override
	public String toString() {
		return "CMSBulkAccountCreationResponse [success=" + success + "]";
	}

}
