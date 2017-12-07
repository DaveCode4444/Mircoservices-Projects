package com.metamagic.fallback;

import org.springframework.stereotype.Service;

import com.metamagic.client.TokenServiceClient;
import com.metamagic.common.bean.MessageWrapper;

@Service
public class TokenServiceFallback implements TokenServiceClient{

	@Override
	public MessageWrapper<Boolean> validateToken(String tokenId) {
		return new MessageWrapper<Boolean>(false, true,"Token validate service is down","token.failed.01");
	}
}
