
package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PayrollDetailsAmendmentResponse"
})
public class PayrollDetailsAmendmentResponseBknd {

    @JsonProperty("PayrollDetailsAmendmentResponse")
    private PayrollDetailsAmendmentResponseTypeBknd payrollDetailsAmendmentResponse;

    @JsonProperty("PayrollDetailsAmendmentResponse")
    public PayrollDetailsAmendmentResponseTypeBknd getPayrollDetailsAmendmentResponse() {
        return payrollDetailsAmendmentResponse;
    }

    @JsonProperty("PayrollDetailsAmendmentResponse")
    public void setPayrollDetailsAmendmentResponse(PayrollDetailsAmendmentResponseTypeBknd payrollDetailsAmendmentResponse) {
        this.payrollDetailsAmendmentResponse = payrollDetailsAmendmentResponse;
    }

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentResponseBknd [payrollDetailsAmendmentResponse=" + payrollDetailsAmendmentResponse
				+ "]";
	}

    

}
