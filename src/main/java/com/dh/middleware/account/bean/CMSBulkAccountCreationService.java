package com.dh.middleware.account.bean;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.alahli.middleware.utility.Utils.NumberUtil;
import com.alahli.middleware.utility.Utils.StringUtil;
import com.alahli.middleware.utility.Utils.Utils;
import com.alahli.middleware.utility.error.ExceptionHandler;
import com.dh.middleware.account.models.CMSBulkAccountCreation;
import com.dh.middleware.account.models.CMSBulkAccountCreationRequest;
import com.dh.middleware.account.models.CMSBulkAccountCreationResponse;
import com.dh.middleware.account.models.CreatedCMSAccountListType;
import com.dh.middleware.account.models.CreatedCMSAccountType;
import com.dh.middleware.account.models.ServiceHeader;
import com.dh.middleware.account.models.backend.cms.CseBusinessBean;
import com.dh.middleware.account.models.backend.cms.ProcessRequest;
import com.dh.middleware.account.models.backend.cms.ProcessRequestResponse;
import com.dh.middleware.account.utility.AccountUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
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

	private CMSBulkAccountCreation oAccountCreation;

	private CMSBulkAccountCreationRequest oCMSBulkAccountCreationRequest;

	public CMSBulkAccountCreation getoAccountCreation() {
		return oAccountCreation;
	}

	public void setoAccountCreation(CMSBulkAccountCreation oAccountCreation) {
		this.oAccountCreation = oAccountCreation;
	}

	public CMSBulkAccountCreationRequest getoCMSBulkAccountCreationRequest() {
		return oCMSBulkAccountCreationRequest;
	}

	public void setoCMSBulkAccountCreationRequest(CMSBulkAccountCreationRequest oCMSBulkAccountCreationRequest) {
		this.oCMSBulkAccountCreationRequest = oCMSBulkAccountCreationRequest;
	}

	private String logContextToken = "37a7d803-a2a8-11ef-e18e-19d35b9b168a:2f40e637-0b26-11ef-e18e-1a001a4d93d1:1.003.001:";

	private String serviceID = "IOMSRV99025";

	public void setCMSBulkAccountCreationRequestIn(CMSBulkAccountCreation accountCreation,
			@Header("ServiceHeader") String serviceHeader) throws JsonMappingException, JsonProcessingException {

		this.oServiceHeader = objectMapper.readValue(serviceHeader, ServiceHeader.class);
		this.oAccountCreation = accountCreation;
		this.oCMSBulkAccountCreationRequest = accountCreation.getAccountCreationRequest();
	}

	public ProcessRequest processRequest(Exchange ex) throws Exception {

		String inputMessage = oAccountCreation.toString();
		CseBusinessBean oCseBusinessBean = new CseBusinessBean();

		oCseBusinessBean.setLogContextToken(logContextToken);
		oCseBusinessBean.setiNPUTMESSAGE(inputMessage);
		oCseBusinessBean.setsERVICEID(serviceID);

		ProcessRequest oProcessRequest = new ProcessRequest();
		oProcessRequest.setLogContextToken(logContextToken);
		oProcessRequest.setArg0(oCseBusinessBean);

		return oProcessRequest;

	}

	public void processResponse(Exchange exchange)
			throws ExceptionHandler, XPathExpressionException, SAXException, IOException {

		Message message = exchange.getIn();
		ProcessRequestResponse oProcessRequestResponse = exchange.getIn().getBody(ProcessRequestResponse.class);
		String responseString = oProcessRequestResponse.getReturn();
		responseString = URLDecoder.decode(responseString, "CP1256");

		// removing %17, %3D and %2C

		String returncode = oAccountUtils.getValueFromCMSResponse("RETURNCODE", responseString);

		CMSBulkAccountCreation oBulkAccountCreation = new CMSBulkAccountCreation();

		if (returncode.equals("0000")) {

			CMSBulkAccountCreationResponse oBulkAccountCreationResponse = new CMSBulkAccountCreationResponse();
			CreatedCMSAccountListType oCMSAccountListType = new CreatedCMSAccountListType();
			List<CreatedCMSAccountType> oCMSAccountType = new ArrayList<CreatedCMSAccountType>();

			String jsonString = this.oAccountUtils.getValueFromCMSResponse("XMLMSG", responseString);

			JsonNode root = this.objectMapper.readTree(jsonString);

			if (root != null) {
				JsonNode accDataArray = root.get("ACCDATA");

				for (JsonNode accDataNode : accDataArray) {

					CreatedCMSAccountType oAccountType = new CreatedCMSAccountType();

					oAccountType
							.setIbanAccountNumber(oStringUtil.setDefaultValue(accDataNode.get("IBANACCOUNTNB"), null));
					oAccountType.setAccountNumber(oStringUtil.setDefaultValue(accDataNode.get("ACCOUNTNB"), null));
					oAccountType.setRemitterId(oStringUtil.setDefaultValue(accDataNode.get("CUSTOMERNB"), null));
					oAccountType.setTransactionNotificationFlag(
							oStringUtil.setDefaultValue(accDataNode.get("ISNOTIFICATIONENABLED"), null));
					oAccountType.setDebitCreditFlag(oStringUtil.setDefaultValue(accDataNode.get("DEBITFLAG"), null));
					oAccountType.setMinimumAccountBalanceLimit(oStringUtil.setDefaultValue("0", null));
					oAccountType.setMaximumAccountBalanceLimit(oStringUtil.setDefaultValue("0", null));
					oAccountType.setSubscriptionFlag(oStringUtil.setDefaultValue("string", null));
					oAccountType.setAccountResetFlag(oStringUtil.setDefaultValue("string", null));

					oCMSAccountType.add(oAccountType);

				}
			}
			oCMSAccountListType.setAccount(oCMSAccountType);
			oBulkAccountCreationResponse.setSuccess(oCMSAccountListType);
			oBulkAccountCreation.setAccountCreationResponse(oBulkAccountCreationResponse);

			message.setBody(oBulkAccountCreation);

		} else {

			String nativeDescription = oAccountUtils.getValueFromCMSResponse("DESCRIPTION", responseString);

			message.setBody(oUtils.prepareFaultNodeStr("CMSBulkAccountCreationResponse", "CMS", "", returncode,
					nativeDescription, "sysOrAppWithBkndError", exchange));
		}

	}

}
