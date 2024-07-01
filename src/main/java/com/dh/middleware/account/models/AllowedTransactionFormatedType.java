
package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orderBy",
    "transactionCode",
    "transactionCodeDescription",
    "isSelected"
})
public class AllowedTransactionFormatedType {

    protected String orderBy;
    protected String transactionCode;
    protected String transactionCodeDescription;
    protected String isSelected;


    public String getOrderBy() {
        return orderBy;
    }


    public void setOrderBy(String value) {
        this.orderBy = value;
    }


    public String getTransactionCode() {
        return transactionCode;
    }


    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }


    public String getTransactionCodeDescription() {
        return transactionCodeDescription;
    }


    public void setTransactionCodeDescription(String value) {
        this.transactionCodeDescription = value;
    }


    public String getIsSelected() {
        return isSelected;
    }


    public void setIsSelected(String value) {
        this.isSelected = value;
    }


	@Override
	public String toString() {
		return "AllowedTransactionFormatedType [orderBy=" + orderBy + ", transactionCode=" + transactionCode
				+ ", transactionCodeDescription=" + transactionCodeDescription + ", isSelected=" + isSelected + "]";
	}

    
}
