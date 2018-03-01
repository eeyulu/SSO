package org.tarena.util;

public class SSOCheck {
	public static final String USERNAME = "user";
	public static final String PASSWORD = "123";

	public static boolean checkLogin(String userName, String pwd) {
		if (userName.equals(USERNAME) && pwd.equals(PASSWORD)) {
			return true;
		} else {
			return false;
		}

	}
	

	public static boolean checkCookie(String cookieName, String cookieValue) {

		if (cookieName.equals("ssocookie") && cookieValue.equals("sso")) {
			return true;
		}
		return false;

	}

}
