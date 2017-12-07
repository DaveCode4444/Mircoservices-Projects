package com.metamagic.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.metamagic.common.bean.MessageWrapper;

public interface LoginService {

	@RequestMapping(value="/authenticate", method=RequestMethod.POST, produces="application/json")
	public MessageWrapper<Object> authenticate(@RequestBody Object loginBean);
}
