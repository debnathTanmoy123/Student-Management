package com.jspiders.app.util;

public class StudentLoginUtil {

	private String loginCrd;
	private String password;

	public String getLoginCrd() {
		return loginCrd;
	}

	public void setLoginCrd(String loginCrd) {
		this.loginCrd = loginCrd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StudentLoginUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentLoginUtil [loginCrd=" + loginCrd + ", password=" + password + "]";
	}

	public StudentLoginUtil(String loginCrd, String password) {
		super();
		this.loginCrd = loginCrd;
		this.password = password;
	}

}
