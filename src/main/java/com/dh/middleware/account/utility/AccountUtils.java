package com.dh.middleware.account.utility;

import org.springframework.stereotype.Component;

@Component
public class AccountUtils {

//	private static char delimiter = '\027';
	private static char delimiter = '\u0017';
	
	  public String getValueFromCMSResponse(String key, String responseString) {
		    String value = null;
		    key = key + "=";
		    try {
		      value = responseString.substring(responseString.indexOf(key));
		      if (value.indexOf(delimiter) >= 0)
		        value = value.substring(key.length(), value.indexOf(delimiter)); 
		    } catch (Exception e) {
//		      logger.error("Exception in getValueFromCMSResponse module with details and hence the value will be responded as empty string ", e);
		      value = "";
		    } 
		    return value;
		  }
}
