package com.metamagic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.client.LoginServiceClient;
import com.metamagic.common.bean.MessageWrapper;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginServiceClient loginServiceClient;
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces="application/json")
	public MessageWrapper<Object> authenticate(@RequestBody Object loginBean){
		
		logger.debug("Request for user authentication");
		
		return loginServiceClient.authenticate(loginBean);
	}

}
