package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayrollDetailsAmendmentRequestBknd {

	@JsonProperty("PayrollDetailsAmendmentRequest")
	private PayrollDetailsAmendmentRequestTypeBknd oPayrollDetailsAmendmentRequestTypeBknd;

	public PayrollDetailsAmendmentRequestTypeBknd getoPayrollDetailsAmendmentRequestTypeBknd() {
		return oPayrollDetailsAmendmentRequestTypeBknd;
	}

	public void setoPayrollDetailsAmendmentRequestTypeBknd(
			PayrollDetailsAmendmentRequestTypeBknd oPayrollDetailsAmendmentRequestTypeBknd) {
		this.oPayrollDetailsAmendmentRequestTypeBknd = oPayrollDetailsAmendmentRequestTypeBknd;
	}

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentRequestBknd [oPayrollDetailsAmendmentRequestTypeBknd="
				+ oPayrollDetailsAmendmentRequestTypeBknd + "]";
	}

	
}
