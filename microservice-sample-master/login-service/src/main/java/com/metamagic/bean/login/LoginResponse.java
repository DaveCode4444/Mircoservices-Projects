package com.metamagic.bean.login;

public class LoginResponse {

	private boolean status;
	
	private String tokenId;

	public LoginResponse(){
	}
	
	public LoginResponse(boolean status, String tokenId) {
		super();
		this.status = status;
		this.tokenId = tokenId;
	}

	public boolean isStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "LoginResponse [status=" + status + ", tokenId=" + tokenId + "]";
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	
	
}
