package com.xebia.jetter.controller;

import com.xebia.jetter.domain.request.ResponseStatus;
import com.xebia.jetter.enums.Status;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spice")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser) {
        ResponseEntity responseEntity;
        ResponseStatus status;
        boolean check = loginService.verifyLoginRequest(loginUser);
        if (check) {
            status = new ResponseStatus("login success", Status.SUCCESS);
            responseEntity = new ResponseEntity(status, HttpStatus.ACCEPTED);
        } else {
            status = new ResponseStatus("login failure", Status.FAILURE);
            responseEntity = new ResponseEntity(status, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
