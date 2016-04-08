package com.xebia.jetter.controller;

import com.xebia.jetter.model.LoginUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spice")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser) {
     g
        return null;
    }
}
