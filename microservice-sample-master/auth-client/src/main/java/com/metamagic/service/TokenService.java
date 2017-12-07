package com.metamagic.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metamagic.common.bean.MessageWrapper;

public interface TokenService {

	@RequestMapping(value="/validateToken/{tokenId}", method=RequestMethod.GET, produces="application/json")
	public MessageWrapper<Boolean> validateToken(@PathVariable("tokenId") String tokenId);
}
