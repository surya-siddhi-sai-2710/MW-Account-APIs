
package com.dh.middleware.account.models.backends.bancs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ACCOUNTID",
    "PAYROLLFLAGINDICATOR",
    "SPECIALACCOUNTINDICATOR",
    "PAYROLLRELEASEINDICATOR",
    "PAYROLLEXPIRYDATE",
    "PAYROLLISSUEDATE",
    "SIEBALREQUESTNUMBER"
})
public class PayrollDetailsAmendmentResponseTypeBknd {

	@JsonProperty("ACCOUNTID")
	private String aCCOUNTID;
	
	@JsonProperty("PAYROLLFLAGINDICATOR")
	private String pAYROLLFLAGINDICATOR;
	
	@JsonProperty("SPECIALACCOUNTINDICATOR")
	private String sPECIALACCOUNTINDICATOR;
	
	@JsonProperty("PAYROLLRELEASEINDICATOR")
	private String pAYROLLRELEASEINDICATOR;
	
	@JsonProperty("PAYROLLEXPIRYDATE")
	private String pAYROLLEXPIRYDATE;
	
	@JsonProperty("PAYROLLISSUEDATE")
	private String pAYROLLISSUEDATE;
	
	@JsonProperty("SIEBALREQUESTNUMBER")
	private String sIEBALREQUESTNUMBER;

	@JsonProperty("ACCOUNTID")
	public String getACCOUNTID() {
		return aCCOUNTID;
	}

	@JsonProperty("ACCOUNTID")
	public void setACCOUNTID(String aCCOUNTID) {
		this.aCCOUNTID = aCCOUNTID;
	}

	@JsonProperty("PAYROLLFLAGINDICATOR")
	public String getPAYROLLFLAGINDICATOR() {
		return pAYROLLFLAGINDICATOR;
	}

	@JsonProperty("PAYROLLFLAGINDICATOR")
	public void setPAYROLLFLAGINDICATOR(String pAYROLLFLAGINDICATOR) {
		this.pAYROLLFLAGINDICATOR = pAYROLLFLAGINDICATOR;
	}

	@JsonProperty("SPECIALACCOUNTINDICATOR")
    public String getSPECIALACCOUNTINDICATOR() {
        return sPECIALACCOUNTINDICATOR;
    }

    @JsonProperty("SPECIALACCOUNTINDICATOR")
    public void setSPECIALACCOUNTINDICATOR(String sPECIALACCOUNTINDICATOR) {
        this.sPECIALACCOUNTINDICATOR = sPECIALACCOUNTINDICATOR;
    }

    @JsonProperty("PAYROLLRELEASEINDICATOR")
    public String getPAYROLLRELEASEINDICATOR() {
        return pAYROLLRELEASEINDICATOR;
    }

    @JsonProperty("PAYROLLRELEASEINDICATOR")
    public void setPAYROLLRELEASEINDICATOR(String pAYROLLRELEASEINDICATOR) {
        this.pAYROLLRELEASEINDICATOR = pAYROLLRELEASEINDICATOR;
    }

    @JsonProperty("PAYROLLEXPIRYDATE")
    public String getPAYROLLEXPIRYDATE() {
        return pAYROLLEXPIRYDATE;
    }

    @JsonProperty("PAYROLLEXPIRYDATE")
    public void setPAYROLLEXPIRYDATE(String pAYROLLEXPIRYDATE) {
        this.pAYROLLEXPIRYDATE = pAYROLLEXPIRYDATE;
    }

    @JsonProperty("PAYROLLISSUEDATE")
    public String getPAYROLLISSUEDATE() {
        return pAYROLLISSUEDATE;
    }

    @JsonProperty("PAYROLLISSUEDATE")
    public void setPAYROLLISSUEDATE(String pAYROLLISSUEDATE) {
        this.pAYROLLISSUEDATE = pAYROLLISSUEDATE;
    }

    @JsonProperty("SIEBALREQUESTNUMBER")
    public String getSIEBALREQUESTNUMBER() {
        return sIEBALREQUESTNUMBER;
    }

    @JsonProperty("SIEBALREQUESTNUMBER")
    public void setSIEBALREQUESTNUMBER(String sIEBALREQUESTNUMBER) {
        this.sIEBALREQUESTNUMBER = sIEBALREQUESTNUMBER;
    }

	@Override
	public String toString() {
		return "PayrollDetailsAmendmentResponseTypeBknd [aCCOUNTID=" + aCCOUNTID + ", pAYROLLFLAGINDICATOR="
				+ pAYROLLFLAGINDICATOR + ", sPECIALACCOUNTINDICATOR=" + sPECIALACCOUNTINDICATOR
				+ ", pAYROLLRELEASEINDICATOR=" + pAYROLLRELEASEINDICATOR + ", pAYROLLEXPIRYDATE=" + pAYROLLEXPIRYDATE
				+ ", pAYROLLISSUEDATE=" + pAYROLLISSUEDATE + ", sIEBALREQUESTNUMBER=" + sIEBALREQUESTNUMBER + "]";
	}

    
}
