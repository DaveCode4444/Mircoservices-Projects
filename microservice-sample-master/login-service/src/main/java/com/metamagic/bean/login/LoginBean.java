package com.metamagic.bean.login;

public class LoginBean {

	private String loginId;
	
	private String password;
	
	public LoginBean(){
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [loginId=" + loginId + ", password=" + password + "]";
	}
	
	

	
}
