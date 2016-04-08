package com.xebia.jetter.controller;

import com.xebia.jetter.model.LoginUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: HJAIN
 * Date: 4/8/16
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/spice")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser)
    {
        System.out.println("****************"+loginUser.getUserName());

                                   return null;
    }
}
