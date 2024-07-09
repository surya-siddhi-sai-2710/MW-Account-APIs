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
import com.dh.middleware.account.models.AllowedTransactionFormatedType;
import com.dh.middleware.account.models.CMSOmniAccountDetails;
import com.dh.middleware.account.models.CMSOmniAccountDetailsRequest;
import com.dh.middleware.account.models.CMSOmniAccountDetailsResponse;
import com.dh.middleware.account.models.CMSOmniAccountDetailsResponseType;
import com.dh.middleware.account.models.CMSOmniAccountDetailsType;
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
public class CMSOmniAccountDetailsService {

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

	private CMSOmniAccountDetails oOmniAccountDetails;

	private CMSOmniAccountDetailsRequest oCmsOmniAccountDetailsRequest;

	public CMSOmniAccountDetails getoOmniAccountDetails() {
		return oOmniAccountDetails;
	}

	public void setoOmniAccountDetails(CMSOmniAccountDetails oOmniAccountDetails) {
		this.oOmniAccountDetails = oOmniAccountDetails;
	}

	public CMSOmniAccountDetailsRequest getoCmsOmniAccountDetailsRequest() {
		return oCmsOmniAccountDetailsRequest;
	}

	public void setoCmsOmniAccountDetailsRequest(CMSOmniAccountDetailsRequest oCmsOmniAccountDetailsRequest) {
		this.oCmsOmniAccountDetailsRequest = oCmsOmniAccountDetailsRequest;
	}

	private String logContextToken = "9f0fde43-dd93-11ef-e4fa-bacee9769f8a:335c16e7-7cc7-11ef-e4fa-bb0b8fd99791:1.003.001:";

	private String serviceID = "IOMSRV99124";

	public void setOmniAccountDetailsRequestIn(CMSOmniAccountDetails cmsOmniAccountDetails,
			@Header("ServiceHeader") String serviceHeader) throws JsonMappingException, JsonProcessingException {

		this.oServiceHeader = objectMapper.readValue(serviceHeader, ServiceHeader.class);
		this.oOmniAccountDetails = cmsOmniAccountDetails;
		this.oCmsOmniAccountDetailsRequest = cmsOmniAccountDetails.getAccountDetailsRequest();
	}

	public ProcessRequest processRequest(Exchange ex) throws Exception {

		String inputMessage = oOmniAccountDetails.toString();
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

		String returncode = oAccountUtils.getValueFromCMSResponse("RETURNCODE", responseString);

		CMSOmniAccountDetails oCMSOmniAccountDetails = new CMSOmniAccountDetails();

		if (returncode.equals("0000")) {

			CMSOmniAccountDetailsResponse oCmsOmniAccountDetailsResponse = new CMSOmniAccountDetailsResponse();
			CMSOmniAccountDetailsResponseType oCmsOmniAccountDetailsResponseType = new CMSOmniAccountDetailsResponseType();
			List<CMSOmniAccountDetailsType> oCMSOmniAccountType = new ArrayList<CMSOmniAccountDetailsType>();

			oCmsOmniAccountDetailsResponseType
					.setStatusCode(oAccountUtils.getValueFromCMSResponse("RETURNCODE", responseString));
			oCmsOmniAccountDetailsResponseType
					.setStatusDescription(oAccountUtils.getValueFromCMSResponse("DESCRIPTION", responseString));
			oCmsOmniAccountDetailsResponseType.setNotes(oAccountUtils.getValueFromCMSResponse("NOTES", responseString));

			String jsonString = this.oAccountUtils.getValueFromCMSResponse("XMLMSG", responseString);

			JsonNode root = this.objectMapper.readTree(jsonString);

			if (root != null) {
				JsonNode accDataArray = root.get("OMNIDATA");

				for (JsonNode accDataNode : accDataArray) {

					CMSOmniAccountDetailsType oOmniAccountType = new CMSOmniAccountDetailsType();

					oOmniAccountType.setInstitutionCode(oStringUtil.setDefaultValue(accDataNode.get("INSTCODE"), null));
					oOmniAccountType
							.setOmniMappedCode(oStringUtil.setDefaultValue(accDataNode.get("OMNIMAPPEDCODE"), null));
					oOmniAccountType
							.setOmniAccountType(oStringUtil.setDefaultValue(accDataNode.get("OMNIACCOUNTTYPE"), null));
					oOmniAccountType.setCurrency(oStringUtil.setDefaultValue(accDataNode.get("CURRENCYCODE"), null));
					oOmniAccountType.setOmniCommisionAccount(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType
							.setOmniEnglishName(oStringUtil.setDefaultValue(accDataNode.get("OMNIENAME"), null));
					oOmniAccountType.setOmniArabicName(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setMainStatus(oStringUtil.setDefaultValue(accDataNode.get("MSTATUS"), null));
					oOmniAccountType
							.setMainStatusDesciption(oStringUtil.setDefaultValue(accDataNode.get("MSTATUSDESC"), null));
					oOmniAccountType.setCreateUserCode(oStringUtil.setDefaultValue(accDataNode.get("CUSERCD"), null));
					oOmniAccountType.setCreateDate(oStringUtil.setDefaultValue(accDataNode.get("CDATE"), null));
					oOmniAccountType.setUpdateUserCode(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setUpdateDate(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setApproveUserCode(oStringUtil.setDefaultValue(accDataNode.get("AUSERCD"), null));
					oOmniAccountType.setApproveDate(oStringUtil.setDefaultValue(accDataNode.get("ADATE"), null));
					oOmniAccountType
							.setAccountOwnerType(oStringUtil.setDefaultValue(accDataNode.get("ACCOWNERTYPE"), null));
					oOmniAccountType.setAccountOwnerTypeDescription(
							oStringUtil.setDefaultValue(accDataNode.get("ACCOWNERTYPEDESC"), null));
					oOmniAccountType.setLastSequenceOfAccount(
							oStringUtil.setDefaultValue(accDataNode.get("ACCOUNTSEQNB"), null));
					oOmniAccountType.setBranchCode(oStringUtil.setDefaultValue(accDataNode.get("BRNCD"), null));
					oOmniAccountType.setCurrencyNumericId(
							oStringUtil.setDefaultValue(accDataNode.get("CURRENCYNUMERICID"), null));
					oOmniAccountType.setCifNumber(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setTransactionNotificationFlag(
							oStringUtil.setDefaultValue(accDataNode.get("DISNOTIFICATIONENABLED"), null));
					oOmniAccountType.setAllowedTransactions(
							oStringUtil.setDefaultValue(accDataNode.get("DALLOWEDTRNTYPES"), null));
					oOmniAccountType.setBlockedTransactions(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setFeeFlag(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setCorporateFeeAccount(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setFeePercentage(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setFeeTransactionCodes(oStringUtil.setDefaultValue("string", null));
					oOmniAccountType.setNumberOfVirtualAccounts(
							oStringUtil.setDefaultValue(accDataNode.get("NUMBEROFVIRTUALACCOUNTS"), null));
					oOmniAccountType
							.setLastUpdateTime(oStringUtil.setDefaultValue(accDataNode.get("LASTUPDATETIME"), null));

					List<AllowedTransactionFormatedType> oAllowedTransactionFormatedTypes = new ArrayList<>();
					JsonNode transactionsNode = accDataNode.get("DALLOWEDTRNTYPESFORMATEDDISPLAY");

					if (transactionsNode != null) {

						for (JsonNode transaction : transactionsNode) {

							AllowedTransactionFormatedType oOmniTransactions = new AllowedTransactionFormatedType();

							oOmniTransactions.setOrderBy(oStringUtil.setDefaultValue(transaction.get("ORDERBY"), null));
							oOmniTransactions.setTransactionCode(
									oStringUtil.setDefaultValue(transaction.get("TRANSACTIONCD"), null));
							oOmniTransactions.setTransactionCodeDescription(
									oStringUtil.setDefaultValue(transaction.get("TRANSACTIONNAME"), null));
							oOmniTransactions
									.setIsSelected(oStringUtil.setDefaultValue(transaction.get("ISSELECTED"), null));

							oAllowedTransactionFormatedTypes.add(oOmniTransactions);
						}

						oOmniAccountType.setTransactions(oAllowedTransactionFormatedTypes);

						oCMSOmniAccountType.add(oOmniAccountType);
					}

				}

			}
			oCmsOmniAccountDetailsResponseType.setAccount(oCMSOmniAccountType);
			oCmsOmniAccountDetailsResponse.setSuccess(oCmsOmniAccountDetailsResponseType);
			oCMSOmniAccountDetails.setAccountDetailsResponse(oCmsOmniAccountDetailsResponse);

			message.setBody(oCMSOmniAccountDetails);

		} else {

			String nativeDescription = oAccountUtils.getValueFromCMSResponse("DESCRIPTION", responseString);

			message.setBody(oUtils.prepareFaultNodeStr("CMSOmniAccountDetailsResponse", "CMS", "", returncode,
					nativeDescription, "sysOrAppWithBkndError", exchange));
		}
	}
}
