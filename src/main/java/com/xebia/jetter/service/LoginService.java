package com.xebia.jetter.service;

import com.xebia.jetter.model.LoginUser;

/**
 * Created by gurinder on 13/4/16.
 */
public interface LoginService {
    boolean verifyLoginRequest(LoginUser loginUser);
}
