package com.dh.middleware.account.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.language.simple.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import oracle.jdbc.OracleTypes;

@Lazy
@Component
public class BANCSDBConnectorImplDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ObjectMapper objectMapper;

	public ObjectNode AmendInquirePayrollDetails(@Simple("${body[PayrollDetailsAmendmentRequest][acctNum]}") String accountId,
			Exchange ex)
			throws Exception {

		Connection conn = null;
		CallableStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataSource.getConnection();
			String strProcedure = "CALL INQUIREPAYROLL(?,?)";
			pstmt = conn.prepareCall(strProcedure);

			pstmt.setString(1, accountId);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);

			pstmt.execute();
			rs = (ResultSet) pstmt.getObject(2);
			ResultSetMetaData rsMetadata = null;
			rsMetadata = rs.getMetaData();
			int noOfColumns = rsMetadata.getColumnCount();

			ObjectNode amendmentPayrollDetails = JsonNodeFactory.instance.objectNode();
			ObjectNode oAmendmentPayrollDetailsNode = amendmentPayrollDetails
					.putObject("PayrollDetailsAmendmentResponse");
			
			while (rs.next()) {

				for (int i = 1; i <= noOfColumns; i++) {

					String columnName = rsMetadata.getColumnName(i);
					String columnValue = rs.getString(i);

					oAmendmentPayrollDetailsNode.put(columnName, columnValue);

				}
			}

			// checking weather the requested data is retrieved or not
			if (amendmentPayrollDetails.size() < 1) {
				return null;
			} else {
				return amendmentPayrollDetails;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ex.getIn().setBody(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (null != conn)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				ex.getIn().setBody(e.getMessage());
			}
		}
		return null;
	}

	public ObjectNode AmendUpdatePayrollDetails(
			@Simple("${body[Transaction][acctNum]}") String accountId,
			@Simple("${body[Transaction][payrollFlagInd]}") String payrollFlagIndicator,
			@Simple("${body[Transaction][splAcctInd]}") String specialAccountIndicator,
			@Simple("${body[Transaction][payrollReleInd]}") String payrollReleaseIndicator,
			@Simple("${body[Transaction][expDt]}") String payrollExpiryDate,
			@Simple("${body[Transaction][issueDt]}") String payrollIssueDate,
			@Simple("${body[Transaction][siebalReqNo]}") String siebalRequestNumber,
			Exchange ex) throws Exception {

		Connection conn = null;
		CallableStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = dataSource.getConnection();
			String strProcedure = "CALL UPDATEPAYROLL(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareCall(strProcedure);

			pstmt.setString(1, accountId);
			pstmt.setString(2, payrollFlagIndicator);
			pstmt.setString(3, specialAccountIndicator);
			pstmt.setString(4, payrollReleaseIndicator);
			pstmt.setString(5, payrollExpiryDate);
			pstmt.setString(6, payrollIssueDate);
			pstmt.setString(7, siebalRequestNumber);

			pstmt.registerOutParameter(8, Types.INTEGER);

			pstmt.execute();

			int rowsAffected = pstmt.getInt(8);

			ObjectNode oPayrollDetailsAmendmentResponseNode = JsonNodeFactory.instance.objectNode();
			ObjectNode oPayrollDetailsAmendmentResponse = oPayrollDetailsAmendmentResponseNode
					.putObject("PayrollDetailsAmendmentResponse");
			ObjectNode oStatus = oPayrollDetailsAmendmentResponse.putObject("success");

			if (rowsAffected > 0) {
				oStatus.put("update", true);
			} else {
				oStatus.put("update", false);
			}

			return oPayrollDetailsAmendmentResponseNode;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ex.getIn().setBody(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (null != conn)
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				ex.getIn().setBody(e.getMessage());
			}
		}

		return null;
	}

}
