package com.metamagic.service;

public interface TokenService {

	public String generateToken(String data);
	
	public void updateTokenLastAccessTime(String tokenId);
	
	public boolean validateToekn(String tokendId);
}
