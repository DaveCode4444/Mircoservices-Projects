package com.metamagic.client;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.metamagic.fallback.LoginServiceFallBack;
import com.metamagic.service.LoginService;

@FeignClient(value="login-service", fallback=LoginServiceFallBack.class)
public interface LoginServiceClient extends LoginService
{

}
