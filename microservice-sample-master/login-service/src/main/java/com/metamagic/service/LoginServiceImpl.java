package com.metamagic.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.metamagic.bean.login.LoginBean;
import com.metamagic.bean.login.LoginResponse;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public LoginResponse authenicate(LoginBean loginBean) {

		LoginResponse loginResponse = new LoginResponse(false, null);
		
		if((loginBean !=null && (loginBean.getLoginId().equals(loginBean.getPassword())))){
			loginResponse.setStatus(true);
			loginResponse.setTokenId(UUID.randomUUID().toString());
			
			// Once authenticate, raise the token creation service which returns token Id. Use token generated instead of UUID string.
		}
		return loginResponse;
	}
}
