package com.dh.middleware.account.models.backend.cms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INPUTMESSAGE", propOrder = {""})
@XmlRootElement(name = "INPUTMESSAGE")
public class InputMessage {

	@XmlElement(name = "INPUTMESSAGE")
	private String inputMessage;

	public String getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	@Override
	public String toString() {
		return "InputMessage [inputMessage=" + inputMessage + "]";
	}

	
	
	
	
}
