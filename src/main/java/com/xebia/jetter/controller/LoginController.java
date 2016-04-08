package com.xebia.jetter.controller;

import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spice")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser) {

        boolean check = loginService.verifyLoginRequest(loginUser);
                 System.out.println(check+"****************");
        return null;
    }
}
