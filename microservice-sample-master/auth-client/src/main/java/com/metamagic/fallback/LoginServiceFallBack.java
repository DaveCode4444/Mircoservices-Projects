package com.metamagic.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.metamagic.client.LoginServiceClient;
import com.metamagic.common.bean.MessageWrapper;

@Service
public class LoginServiceFallBack implements LoginServiceClient{

	private static Logger logger = LoggerFactory.getLogger(LoginServiceFallBack.class);
	
	@Override
	public MessageWrapper<Object> authenticate(Object loginBean) {
		logger.error("Service for user authentication is down");
		return  new MessageWrapper<Object>(null, false,"User Authentication Service is down","login.service.down.01");
	}
}
