package com.dh.middleware.account.bean;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alahli.middleware.utility.Utils.NumberUtil;
import com.alahli.middleware.utility.Utils.StringUtil;
import com.alahli.middleware.utility.Utils.Utils;
import com.dh.middleware.account.models.CMSBulkAccountCreation;
import com.dh.middleware.account.models.CMSBulkAccountCreationRequest;
import com.dh.middleware.account.models.CMSBulkAccountCreationResponse;
import com.dh.middleware.account.models.CreatedCMSAccountListType;
import com.dh.middleware.account.models.CreatedCMSAccountType;
import com.dh.middleware.account.models.ServiceHeader;
import com.dh.middleware.account.models.backend.cms.Arg0;
import com.dh.middleware.account.models.backend.cms.InputMessage;
import com.dh.middleware.account.models.backend.cms.ProcessRequest;
import com.dh.middleware.account.utils.AccountUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CMSBulkAccountCreationService {
  
	  @Autowired
	  Utils oUtils;
	  
	  @Autowired
	  StringUtil oStringUtil;
	  
	  @Autowired
	  NumberUtil oNumberUtil;
	  
	  @Autowired
	  ObjectMapper objectMapper;
	  
	  @Autowired
	  private AccountUtils oAccountUtils;
	  
	  private ServiceHeader oServiceHeader;
	  
	  private CMSBulkAccountCreationRequest oCMSBulkAccountCreationRequest;
	  
	  
	  
	  XPath xPath = XPathFactory.newInstance().newXPath();
	  
	  private String logContextToken = "37a7d803-a2a8-11ef-e18e-19d35b9b168a:2f40e637-0b26-11ef-e18e-1a001a4d93d1:1.003.001:";
	  
	  private String serviceID = "IOMSRV99025";
	  
	  public void setCMSBulkAccountCreationRequestIn(CMSBulkAccountCreation accountCreation, 
			  @Header("ServiceHeader") String serviceHeader) throws Exception{
		  
		  this.oServiceHeader = objectMapper.readValue(serviceHeader, ServiceHeader.class);
		  this.oCMSBulkAccountCreationRequest = accountCreation.getAccountCreationRequest();
	  }
	  
	  
	  public ProcessRequest prepareProcessRequest() throws Exception{
		  
		ProcessRequest oProcessRequest = new ProcessRequest();
		Arg0 oArg0 = new Arg0();
		InputMessage oInputMessage = new InputMessage();
		
		oProcessRequest.setArg0(oArg0);
		oArg0.setiNPUTMESSAGE(oInputMessage);
		
		oArg0.setLogContextToken(logContextToken);
		oArg0.setsERVICEID(serviceID);
		
		oProcessRequest.setLogContextToken(logContextToken);
		
		StringBuilder inputMessage = new StringBuilder();
		// %17 is space(" ")
		// %3D is "="
		
		inputMessage.append("SERVICEID%3DIOMSRV99025%17INSTCODE%3DNCB%17PRODUCT%3DCMS%17CHANNEL%3DDTOP%17REQUESTUSER%3DecorpGen%17CHANNELUSERID%3DecorpGen%17LANGUAGE%3DEN%17UNIQUEREFERENCE%3DCOR1715149817678%17FUNCTIONID%3DFRM_CMCMNM%17REQUESTMODE%3DBULK%17OPERATIONID%3DBULK%17VALIDATEMODE%3DNO%17ZIPREPLY%3DN%17")
		.append("%17OMNIENAME%3D").append(oCMSBulkAccountCreationRequest.getOmniEnglishName())
		.append("%17BULKCOUNT%3D").append(oCMSBulkAccountCreationRequest.getBulkCount())
		.append("%17OMNIMAPPEDCODE%3D").append(oCMSBulkAccountCreationRequest.getOmniMappedCode())
		.append("%17OMNIANAME%3D").append(oCMSBulkAccountCreationRequest.getOmniArabicName())
		.append("%17CURRENCY%3D").append(oCMSBulkAccountCreationRequest.getCurrency())
		.append("%17OMNIACCOUNTNB%3D").append(oCMSBulkAccountCreationRequest.getOmniAccountNumber())
		.append("%17CUSTOMERNBFROM%3D").append(oCMSBulkAccountCreationRequest.getRemitterIdFrom())
		.append("%17CUSTOMERNBTO%3D").append(oCMSBulkAccountCreationRequest.getRemitterIdTo())
		.append("%17ALLOWEDTRNTYPESFORMATED%3D").append(oCMSBulkAccountCreationRequest.getBlockedTransactions())
		.append("%17USERAUDITCOMMENTS%3D").append(oCMSBulkAccountCreationRequest.getUserComments())
		.append("%17ISNOTIFICATIONENABLED%3D").append(oCMSBulkAccountCreationRequest.getTransactionNotificationFlag())
		.append("%17DEBITCREDITFLAG%3D").append(oCMSBulkAccountCreationRequest.getDebitCreditFlag())
		.append("%17MINIMUMLIMIT%3D").append(oCMSBulkAccountCreationRequest.getMinimumAccountBalanceLimit())
		.append("%17MAXIMUMLIMIT%3D").append(oCMSBulkAccountCreationRequest.getMaximumAccountBalanceLimit())
		.append("%17MT940SUBSCRIPTIONFLAG%3D").append(oCMSBulkAccountCreationRequest.getSubscriptionFlag())
		.append("%17ACCOUNTRESETFLAG%3D").append(oCMSBulkAccountCreationRequest.getAccountResetFlag());
		
		oInputMessage.setInputMessage(inputMessage.toString());
//		System.out.println(oProcessRequest.toString());
		return oProcessRequest;
		  
	  }
	  
	  
	  public CMSBulkAccountCreation prepareXMLResponse(Exchange ex) throws Exception{
		  
		  String xmlResponseString = ex.getIn().getBody(String.class);
		  
		  // removing %17, %3D and %2C
		  String decodedXmlResponseString = URLDecoder.decode(xmlResponseString,"CP1256");
//		  System.out.println("decoded xml "+ " " + decodedXmlResponseString);
		  
		  String returncode = this.oAccountUtils.getValueFromCMSResponse("RETURNCODE", decodedXmlResponseString);
//		  System.out.println("return code "+ " " + returncode);
		  
		  CMSBulkAccountCreation oBulkAccountCreation = new CMSBulkAccountCreation();
		  
		  if (returncode.equals("0000")) {
			  
			  CMSBulkAccountCreationResponse oBulkAccountCreationResponse = new CMSBulkAccountCreationResponse();
			  CreatedCMSAccountListType oCMSAccountListType = new CreatedCMSAccountListType();
			  List<CreatedCMSAccountType> oCMSAccountType = new ArrayList<>();
			    
			  String jsonString = this.oAccountUtils.getValueFromCMSResponse("XMLMSG", decodedXmlResponseString);
			  
//			  System.out.println("jsonString " + jsonString);
			  
			  JsonNode root = this.objectMapper.readTree(jsonString);
			  if (root != null) {
				  JsonNode accdataArrays = root.get("ACCDATA");
			        for (JsonNode accdata : accdataArrays) {
			        	CreatedCMSAccountType oAccountType = new CreatedCMSAccountType();
			        	
			        	oAccountType.setIbanAccountNumber(this.oStringUtil.setDefaultValue(accdata.get("IBANACCOUNTNB"),null));
			        	oAccountType.setAccountNumber(this.oStringUtil.setDefaultValue(accdata.get("ACCOUNTNB"),null));
			        	oAccountType.setRemitterId(this.oStringUtil.setDefaultValue(accdata.get("CUSTOMERNB"), null));
			        	oAccountType.setTransactionNotificationFlag(this.oStringUtil.setDefaultValue(accdata.get("ISNOTIFICATIONENABLED"), null));
			        	oAccountType.setDebitCreditFlag(this.oStringUtil.setDefaultValue(accdata.get("DEBITFLAG"), null));
			        	oAccountType.setMinimumAccountBalanceLimit(this.oStringUtil.setDefaultValue("0", null));
			        	oAccountType.setMaximumAccountBalanceLimit(this.oStringUtil.setDefaultValue("0", null));
			        	oAccountType.setSubscriptionFlag(this.oStringUtil.setDefaultValue("string", null));
			        	oAccountType.setAccountResetFlag(this.oStringUtil.setDefaultValue("string", null));
			        	
			        	oCMSAccountType.add(oAccountType);
			        	
			        }
			  }
			  oCMSAccountListType.setAccount(oCMSAccountType);
			  oBulkAccountCreationResponse.setSuccess(oCMSAccountListType);
			  oBulkAccountCreation.setAccountCreationResponse(oBulkAccountCreationResponse);
			  
			  
//			  System.out.println(oBulkAccountCreation.toString());
		  }
 
		  return oBulkAccountCreation;
		  
	  }
	  
}
