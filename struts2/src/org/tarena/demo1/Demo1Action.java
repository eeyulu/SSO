package org.tarena.demo1;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.tarena.util.SSOCheck;

public class Demo1Action {
	private String gotoUrl;
	
	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(SSOCheck.checkCookie(request)) {
			return "success";
		}
		gotoUrl = "/demo1/main";
		return "login";
	}

}
