package org.tarena.action;

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

	

	public String execute(){
		//��ȡ�������������Service,Dao����
		System.out.println(userName);
		System.out.println(pwd);
		if("a".equals(userName) && ("1".equals(pwd))){
			//1.����Map�ṹ��Session---------ActionContext
			ActionContext ctx = ActionContext.getContext();
			Map<String,Object> session = ctx.getSession();
			session.put("user", userName);
//			ctx.getApplication();
//			ctx.get("request");
			//2.����HttpServletRequest---------ServletActionContext
			HttpServletRequest httpRequest =  ServletActionContext.getRequest();
			HttpSession httpSession = httpRequest.getSession();
			httpSession.setAttribute("password", pwd);
			

			return "success";
		}
		msg = "�û������������";
		return "error";
		
	}
	
	public String doLogin() {
		boolean ok = SSOCheck.checkLogin(userName, pwd);
		if(ok) {
			Cookie  cookie = new Cookie("ssocookie","sso");
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return "success";
		}
		return null;
	}
}
