package www.x.com;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import www.x.com.utils.SSOCheck;


public class LoginAction {
	//�����������
	private String userName;//��ҳ��<input type="text" name="userName" />��name��Ӧ
	private String pwd;//��Ա������
	private String gotoUrl;
	
	private String cookieName;
	private String cookieValue;
	
	

	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public String getCookieValue() {
		return cookieValue;
	}
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}
	public String getGotoUrl() {
		return gotoUrl;
	}
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	



	
	public void doLogin() throws IOException {
		boolean ok = SSOCheck.checkLogin(userName, pwd);
		String result = "0";
		if(ok) {
			result = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();

	}
	
	/**
	 * 检查cookie
	 * @throws IOException 
	 */
	public void checkCookie() throws IOException {
		boolean ok = SSOCheck.checkCookie(cookieName, cookieValue);
		String result = "0";
		if(ok) {
			result = "1";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().print(result);
		response.getWriter().close();
	}
}
