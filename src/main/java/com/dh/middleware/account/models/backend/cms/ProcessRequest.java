package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processRequest", propOrder = {"arg0"})
@XmlRootElement(name = "processRequest")
public class ProcessRequest {
	
	@XmlAttribute(name = "logcontexttoken")
    protected String logContextToken;

	@XmlElement(name="arg0", namespace = "")
	private Arg0 arg0;

	public Arg0 getArg0() {
		return arg0;
	}

	public void setArg0(Arg0 arg0) {
		this.arg0 = arg0;
	}


	public String getLogContextToken() {
		return logContextToken;
	}

	public void setLogContextToken(String logContextToken) {
		this.logContextToken = logContextToken;
	}

	@Override
	public String toString() {
		return "ProcessRequest [logContextToken=" + logContextToken + ", arg0=" + arg0 + "]";
	}
	
	
}
