package demo1.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import demo1.x.com.utils.Demo1Tool;

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
		Cookie [] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie :cookies) {
				if(cookie.getName().equals("ssocookie")){
					String result = Demo1Tool.doGet("http://check.x.com:8080/struts2/sso/checkCookie", cookie.getName(), cookie.getValue());
					if(result.equals("1")) {
						return "success";
					}
				}
			}
		}
		gotoUrl = "http://demo1.x.com:8080/struts2/demo1/main";
		return "login";
	}

}
