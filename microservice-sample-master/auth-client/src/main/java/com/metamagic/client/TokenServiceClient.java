package com.metamagic.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.metamagic.fallback.TokenServiceFallback;
import com.metamagic.service.TokenService;

@FeignClient(value="token-service", fallback=TokenServiceFallback.class)
public interface TokenServiceClient extends TokenService{

}
