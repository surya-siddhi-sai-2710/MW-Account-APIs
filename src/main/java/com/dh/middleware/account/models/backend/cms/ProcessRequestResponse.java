package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processRequestResponse", propOrder = {
    "_return"
})
@XmlRootElement(name = "processRequestResponse",namespace = "http://web.cse.com/")
public class ProcessRequestResponse {

	@XmlElement(name = "return")
    protected String _return;

	public String getReturn() {
		return _return;
	}

	public void setReturn(String _return) {
		this._return = _return;
	}
	
	
}
