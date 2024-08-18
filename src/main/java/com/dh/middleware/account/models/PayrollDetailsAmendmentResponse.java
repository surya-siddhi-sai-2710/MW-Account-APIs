
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "success"
})
public class PayrollDetailsAmendmentResponse {

    @JsonProperty("success")
    private Success success;

    @JsonProperty("success")
    public Success getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Success success) {
        this.success = success;
    }

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentResponse [success=" + success + "]";
	}

}
