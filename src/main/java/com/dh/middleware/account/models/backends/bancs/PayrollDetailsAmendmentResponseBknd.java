package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PayrollDetailsAmendmentReponse"
})
public class PayrollDetailsAmendmentResponseBknd {

	@JsonProperty("Transaction")
	protected PayrollDetailsAmendmentResponseTypeBknd transaction;

	public PayrollDetailsAmendmentResponseTypeBknd getTransaction() {
		return transaction;
	}

	public void setTransaction(PayrollDetailsAmendmentResponseTypeBknd transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "InquirePayrollDetails_007088_007089Response [transaction=" + transaction + "]";
	}

	
	
}
