package com.dh.middleware.account.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountUtils {

	private static char delimiter = '\027';
	
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
