package demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import demo2.x.com.utils.Demo2Tool;

public class Demo2Action {
	
	private String gotoUrl;
	
	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie :cookies) {
				if(cookie.getName().equals("ssocookie")){
					String result = Demo2Tool.doGet("http://check.x.com:8080/struts2/sso/checkCookie", cookie.getName(), cookie.getValue());
					if(result.equals("1")) {
						return "success";
					}
				}
			}
		}
		gotoUrl = "http://demo2.x.com:8080/struts2/demo2/main";
		return "login";
	}
}
