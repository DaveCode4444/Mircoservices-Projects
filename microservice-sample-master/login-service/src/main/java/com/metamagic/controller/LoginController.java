package com.metamagic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.bean.login.LoginBean;
import com.metamagic.bean.login.LoginResponse;
import com.metamagic.common.bean.MessageWrapper;
import com.metamagic.service.LoginService;

@RestController
//@RequestMapping("/loginservice")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces="application/json")
	public MessageWrapper<LoginResponse> authenticate(@RequestBody LoginBean loginBean){
		logger.debug("User authentication service");
		LoginResponse loginResponse = loginService.authenicate(loginBean);
		if(loginResponse.isStatus())
			return new MessageWrapper<LoginResponse>( loginResponse, true,"Authenication successfull",null);
		else
			return new MessageWrapper<LoginResponse>(loginResponse, false,"Incorrect userid password","login.failed.01");
	}
}
