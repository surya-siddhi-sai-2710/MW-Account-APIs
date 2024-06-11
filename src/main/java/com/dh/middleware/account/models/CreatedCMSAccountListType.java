
package com.dh.middleware.account.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "account"
})
public class CreatedCMSAccountListType {

	@JsonProperty("account")
    protected List<CreatedCMSAccountType> account;

    public List<CreatedCMSAccountType> getAccount() {
        if (account == null) {
            account = new ArrayList<CreatedCMSAccountType>();
        }
        return this.account;
    }

	public void setAccount(List<CreatedCMSAccountType> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "CreatedCMSAccountListType [account=" + account + "]";
	}

}
