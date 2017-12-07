package com.metamagic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.common.bean.MessageWrapper;
import com.metamagic.service.TokenService;

@RestController
//@RequestMapping("/tokenservice")
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value ="/generatetoken/{data}", method=RequestMethod.GET, produces="application/json")
	public MessageWrapper<String> generateToken(@PathVariable String data){
		String tokenId = tokenService.generateToken(data); 
		return new MessageWrapper<String>(tokenId, true, "Token generated ", "tokenservice.generate.success.01");
	}
	
	@RequestMapping(value="/validateToken/{tokenId}", method=RequestMethod.GET, produces="application/json")
	public MessageWrapper<Boolean> validateToken(@PathVariable String tokenId){
		Boolean tokenStatus = tokenService.validateToekn(tokenId);
		return new MessageWrapper<Boolean>(tokenStatus,true,"Token validated","tokenservice.valid.success.01");
	}
}
