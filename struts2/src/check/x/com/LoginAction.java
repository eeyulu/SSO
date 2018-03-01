package check.x.com;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.tarena.util.SSOCheck;

import com.opensymphony.xwork2.ActionContext;

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
	//��������userName--->��Ӧҳ������ֵ(ҳ�桪��>Action)
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//${userName}(Action����>ҳ��)
	public String getUserName() {
		return userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	//������Ϣ
	private String msg;//JSP��${msg}
	//get������ҳ�洫ֵ
	public String getMsg() {
		return msg;
	}


	
	public String doLogin() {
		boolean ok = SSOCheck.checkLogin(userName, pwd);
		if(ok) {
			Cookie  cookie = new Cookie("ssocookie","sso");
			cookie.setDomain(".x.com");//设置父域
			cookie.setPath("/");//设置cookie在域的顶层
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return "success";
		}
		return null;
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
