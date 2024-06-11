
package com.dh.middleware.account.models.backend.cms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreatedCMSAccountListType", propOrder = {
    "account"
})
public class CMSAccountListType {

	@XmlElement(name = "account")
    protected List<CMSAccountType> account;

    
    public List<CMSAccountType> getAccount() {
        if (account == null) {
            account = new ArrayList<CMSAccountType>();
        }
        return this.account;
    }


	public void setAccount(List<CMSAccountType> account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "CMSAccountListType [account=" + account + "]";
	}

}
