package com.dh.middleware.account.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CMSAccountsRequest",
    "CMSBulkAccountCreationResponse"
})
public class CMSBulkAccountCreation {

	@JsonProperty("CMSAccountsRequest")
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
		
		if (accountCreationRequest == null) {
            return "{\"CMSAccountsRequest\": null}";
        }
		
		return "{" + "\"CMSAccountsRequest\": {" + "\"omniMappedCode\": \"" + accountCreationRequest.getOmniMappedCode()
				+ "\"," + "\"bulkCount\": \"" + accountCreationRequest.getBulkCount() + "\","
				+ "\"omniEnglishName\": \"" + accountCreationRequest.getOmniEnglishName() + "\","
				+ "\"omniArabicName\": \"" + accountCreationRequest.getOmniArabicName() + "\"," + "\"currency\": \""
				+ accountCreationRequest.getCurrency() + "\"," + "\"omniAccountNumber\": \""
				+ accountCreationRequest.getOmniAccountNumber() + "\"," + "\"remitterIdFrom\": \""
				+ accountCreationRequest.getRemitterIdFrom() + "\"," + "\"remitterIdTo\": \""
				+ accountCreationRequest.getRemitterIdTo() + "\"," + "\"blockedTransactions\": \""
				+ accountCreationRequest.getBlockedTransactions() + "\"," + "\"userComments\": \""
				+ accountCreationRequest.getUserComments() + "\"," + "\"transactionNotificationFlag\": \""
				+ accountCreationRequest.getTransactionNotificationFlag() + "\"," + "\"debitFlag\": \""
				+ accountCreationRequest.getDebitCreditFlag() + "\"," + "\"minimumAccountBalanceLimit\": \""
				+ accountCreationRequest.getMinimumAccountBalanceLimit() + "\"," + "\"maximumAccountBalanceLimit\": \""
				+ accountCreationRequest.getMaximumAccountBalanceLimit() + "\"," + "\"subscriptionFlag\": \""
				+ accountCreationRequest.getSubscriptionFlag() + "\"," + "\"accountResetFlag\": \""
				+ accountCreationRequest.getAccountResetFlag() + "\"" + "}" + "}";
		
//		return	
//				"" + "OMNIENAME=" + accountCreationRequest.getOmniEnglishName()
//				+ "BULKCOUNT=" + accountCreationRequest.getBulkCount()
//				+ "OMNIMAPPEDCODE=" + accountCreationRequest.getOmniMappedCode()
//				+ "OMNIANAME=" + accountCreationRequest.getOmniArabicName()
//				+ "CURRENCY=" + accountCreationRequest.getCurrency()
//				+ "OMNIACCOUNTNB=" + accountCreationRequest.getOmniAccountNumber() 
//				+ "CUSTOMERNBFROM=" + accountCreationRequest.getRemitterIdFrom() 
//				+ "CUSTOMERNBTO=" + accountCreationRequest.getRemitterIdTo() 
//				+ "ALLOWEDTRNTYPESFORMATED=" + accountCreationRequest.getBlockedTransactions() 
//				+ "USERAUDITCOMMENTS=" + accountCreationRequest.getUserComments() 
//				+ "ISNOTIFICATIONENABLED=" + accountCreationRequest.getTransactionNotificationFlag() 
//				+ "DEBITCREDITFLAG=" + accountCreationRequest.getDebitCreditFlag() 
//				+ "MINIMUMLIMIT=" + accountCreationRequest.getMinimumAccountBalanceLimit() 
//				+ "MAXIMUMLIMIT=" + accountCreationRequest.getMaximumAccountBalanceLimit() 
//				+ "MT940SUBSCRIPTIONFLAG=" + accountCreationRequest.getSubscriptionFlag() 
//				+ "ACCOUNTRESETFLAG=" + accountCreationRequest.getAccountResetFlag();
	}

	
}
