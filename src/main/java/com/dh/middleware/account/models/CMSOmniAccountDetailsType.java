
package com.dh.middleware.account.models;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "institutionCode", 
	"omniMappedCode", 
	"omniAccountType", 
	"currency", 
	"omniCommisionAccount",	
	"omniEnglishName", 
	"omniArabicName", 
	"mainStatus", 
	"mainStatusDesciption", 
	"createUserCode", 
	"createDate",	
	"updateUserCode", 
	"updateDate", 
	"approveUserCode", 
	"approveDate", 
	"accountOwnerType",	
	"accountOwnerTypeDescription", 
	"lastSequenceOfAccount", 
	"branchCode", 
	"currencyNumericId", 
	"cifNumber",
	"transactionNotificationFlag", 
	"allowedTransactions", 
	"blockedTransactions", 
	"feeFlag", 
	"corporateFeeAccount",	
	"feePercentage", 
	"feeTransactionCodes", 
	"numberOfVirtualAccounts", 
	"lastUpdateTime", 
	"transactions" 
	})

public class CMSOmniAccountDetailsType {

	protected String institutionCode;
	protected String omniMappedCode;
	protected String omniAccountType;
	protected String currency;
	protected String omniCommisionAccount;
	protected String omniEnglishName;
	protected String omniArabicName;
	protected String mainStatus;
	protected String mainStatusDesciption;
	protected String createUserCode;
	protected String createDate;
	protected String updateUserCode;
	protected String updateDate;
	protected String approveUserCode;
	protected String approveDate;
	protected String accountOwnerType;
	protected String accountOwnerTypeDescription;
	protected String lastSequenceOfAccount;
	protected String branchCode;
	protected String currencyNumericId;
	protected String cifNumber;
	protected String transactionNotificationFlag;
	protected String allowedTransactions;
	protected String blockedTransactions;
	protected String feeFlag;
	protected String corporateFeeAccount;
	protected String feePercentage;
	protected String feeTransactionCodes;
	protected String numberOfVirtualAccounts;
	protected String lastUpdateTime;
	protected List<AllowedTransactionFormatedType> transactions;

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String value) {
		this.institutionCode = value;
	}

	public String getOmniMappedCode() {
		return omniMappedCode;
	}

	public void setOmniMappedCode(String value) {
		this.omniMappedCode = value;
	}

	public String getOmniAccountType() {
		return omniAccountType;
	}

	public void setOmniAccountType(String value) {
		this.omniAccountType = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String value) {
		this.currency = value;
	}

	public String getOmniCommisionAccount() {
		return omniCommisionAccount;
	}

	public void setOmniCommisionAccount(String value) {
		this.omniCommisionAccount = value;
	}

	public String getOmniEnglishName() {
		return omniEnglishName;
	}

	public void setOmniEnglishName(String value) {
		this.omniEnglishName = value;
	}

	public String getOmniArabicName() {
		return omniArabicName;
	}

	public void setOmniArabicName(String value) {
		this.omniArabicName = value;
	}

	public String getMainStatus() {
		return mainStatus;
	}

	public void setMainStatus(String value) {
		this.mainStatus = value;
	}

	public String getMainStatusDesciption() {
		return mainStatusDesciption;
	}

	public void setMainStatusDesciption(String value) {
		this.mainStatusDesciption = value;
	}

	public String getCreateUserCode() {
		return createUserCode;
	}

	public void setCreateUserCode(String value) {
		this.createUserCode = value;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String value) {
		this.createDate = value;
	}

	public String getUpdateUserCode() {
		return updateUserCode;
	}

	public void setUpdateUserCode(String value) {
		this.updateUserCode = value;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String value) {
		this.updateDate = value;
	}

	public String getApproveUserCode() {
		return approveUserCode;
	}

	public void setApproveUserCode(String value) {
		this.approveUserCode = value;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String value) {
		this.approveDate = value;
	}

	public String getAccountOwnerType() {
		return accountOwnerType;
	}

	public void setAccountOwnerType(String value) {
		this.accountOwnerType = value;
	}

	public String getAccountOwnerTypeDescription() {
		return accountOwnerTypeDescription;
	}

	public void setAccountOwnerTypeDescription(String value) {
		this.accountOwnerTypeDescription = value;
	}

	public String getLastSequenceOfAccount() {
		return lastSequenceOfAccount;
	}

	public void setLastSequenceOfAccount(String value) {
		this.lastSequenceOfAccount = value;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String value) {
		this.branchCode = value;
	}

	public String getCurrencyNumericId() {
		return currencyNumericId;
	}

	public void setCurrencyNumericId(String value) {
		this.currencyNumericId = value;
	}

	public String getCifNumber() {
		return cifNumber;
	}

	public void setCifNumber(String value) {
		this.cifNumber = value;
	}

	public String getTransactionNotificationFlag() {
		return transactionNotificationFlag;
	}

	public void setTransactionNotificationFlag(String value) {
		this.transactionNotificationFlag = value;
	}

	public String getAllowedTransactions() {
		return allowedTransactions;
	}

	public void setAllowedTransactions(String value) {
		this.allowedTransactions = value;
	}

	public String getBlockedTransactions() {
		return blockedTransactions;
	}

	public void setBlockedTransactions(String value) {
		this.blockedTransactions = value;
	}

	public String getFeeFlag() {
		return feeFlag;
	}

	public void setFeeFlag(String value) {
		this.feeFlag = value;
	}

	public String getCorporateFeeAccount() {
		return corporateFeeAccount;
	}

	public void setCorporateFeeAccount(String value) {
		this.corporateFeeAccount = value;
	}

	public String getFeePercentage() {
		return feePercentage;
	}

	public void setFeePercentage(String value) {
		this.feePercentage = value;
	}

	public String getFeeTransactionCodes() {
		return feeTransactionCodes;
	}

	public void setFeeTransactionCodes(String value) {
		this.feeTransactionCodes = value;
	}

	public String getNumberOfVirtualAccounts() {
		return numberOfVirtualAccounts;
	}

	public void setNumberOfVirtualAccounts(String value) {
		this.numberOfVirtualAccounts = value;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String value) {
		this.lastUpdateTime = value;
	}

	public List<AllowedTransactionFormatedType> getTransactions() {
		if (transactions == null) {
			transactions = new ArrayList<AllowedTransactionFormatedType>();
		}
		return this.transactions;
	}

	public void setTransactions(List<AllowedTransactionFormatedType> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "CMSOmniAccountDetailsType [institutionCode=" + institutionCode + ", omniMappedCode=" + omniMappedCode
				+ ", omniAccountType=" + omniAccountType + ", currency=" + currency + ", omniCommisionAccount="
				+ omniCommisionAccount + ", omniEnglishName=" + omniEnglishName + ", omniArabicName=" + omniArabicName
				+ ", mainStatus=" + mainStatus + ", mainStatusDesciption=" + mainStatusDesciption + ", createUserCode="
				+ createUserCode + ", createDate=" + createDate + ", updateUserCode=" + updateUserCode + ", updateDate="
				+ updateDate + ", approveUserCode=" + approveUserCode + ", approveDate=" + approveDate
				+ ", accountOwnerType=" + accountOwnerType + ", accountOwnerTypeDescription="
				+ accountOwnerTypeDescription + ", lastSequenceOfAccount=" + lastSequenceOfAccount + ", branchCode="
				+ branchCode + ", currencyNumericId=" + currencyNumericId + ", cifNumber=" + cifNumber
				+ ", transactionNotificationFlag=" + transactionNotificationFlag + ", allowedTransactions="
				+ allowedTransactions + ", blockedTransactions=" + blockedTransactions + ", feeFlag=" + feeFlag
				+ ", corporateFeeAccount=" + corporateFeeAccount + ", feePercentage=" + feePercentage
				+ ", feeTransactionCodes=" + feeTransactionCodes + ", numberOfVirtualAccounts="
				+ numberOfVirtualAccounts + ", lastUpdateTime=" + lastUpdateTime + ", transactions=" + transactions
				+ "]";
	}

}
