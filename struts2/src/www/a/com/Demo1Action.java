package www.a.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import www.a.com.utils.Demo1Tool;



public class Demo1Action {
	private String username;
	private String pwd;
	private String gotoUrl;
	private String path;
	private List<String> hiddenUrl;
	
	


	public List<String> getHiddenUrl() {
		return hiddenUrl;
	}

	public void setHiddenUrl(List<String> hiddenUrl) {
		this.hiddenUrl = hiddenUrl;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

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
					Map<String,String> map = new HashMap<String,String>();
					map.put("cookieName", cookie.getName());
					map.put("cookieValue", cookie.getValue());
					String result = Demo1Tool.doGet("http://www.x.com:8080/struts2/sso/checkCookie", map);
					if(result.equals("1")) {
						return "success";
					}
				}
			}
		}
		path = "http://www.a.com:8080/struts2/demo1";
		gotoUrl = "http://www.a.com:8080/struts2/demo1/main";
		return "login";
	}
	
	public String doLogin() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userName", username);
		map.put("pwd", pwd);
		String result = Demo1Tool.doGet("http://www.x.com:8080/struts2/sso/doLogin", map);
		if(result.equals("1")) {
			hiddenUrl = new ArrayList<String>();
			hiddenUrl.add("http://www.a.com:8080/struts2/demo1/addCookie");
			hiddenUrl.add("http://www.b.com:8080/struts2/demo2/addCookie");
			return "success";
		}
		return "login";
	}
	
	public void addCookie() {
		Cookie cookie = new Cookie("ssocookie","sso");
		cookie.setPath("/");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(cookie);
	}

}
