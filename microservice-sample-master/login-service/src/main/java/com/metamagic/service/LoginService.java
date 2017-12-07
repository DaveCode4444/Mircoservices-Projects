package com.metamagic.service;

import com.metamagic.bean.login.LoginBean;
import com.metamagic.bean.login.LoginResponse;

public interface LoginService {

	public LoginResponse authenicate(LoginBean loginBean);
}
