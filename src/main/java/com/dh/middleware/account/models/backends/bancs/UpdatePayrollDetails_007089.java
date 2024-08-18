package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PayrollDetailsAmendmentRequest"
})
public class UpdatePayrollDetails_007089 {
	
	@JsonProperty("Transaction")
	protected PayrollDetailsAmendmentRequestTypeBknd transaction;

	public PayrollDetailsAmendmentRequestTypeBknd getTransaction() {
		return transaction;
	}

	public void setTransaction(PayrollDetailsAmendmentRequestTypeBknd transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "UpdatePayrollDetails_007089 [transaction=" + transaction + "]";
	}	
	
}
