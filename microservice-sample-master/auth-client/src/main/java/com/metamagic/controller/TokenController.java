package com.metamagic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metamagic.client.TokenServiceClient;
import com.metamagic.common.bean.MessageWrapper;

@RestController
@RequestMapping("/token")
public class TokenController {

	private static Logger logger = LoggerFactory.getLogger(TokenController.class);
	
	@Autowired
	private TokenServiceClient tokenServiceCient;
	
	@RequestMapping(value="/validateToken/{tokenId}", method=RequestMethod.GET, produces="application/json")
	public MessageWrapper<Boolean> validateToken(@PathVariable("tokenId") String tokenId){
		
		logger.debug("Request for token authentication"+tokenId);
		
		return tokenServiceCient.validateToken(tokenId);
	}
	
	
}
