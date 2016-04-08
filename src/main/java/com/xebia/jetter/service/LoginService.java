package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerDao;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: HJAIN
 * Date: 4/9/16
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginService {

    @Autowired
    PassengerDao passengerDao;

    public boolean verifyLoginRequest(LoginUser loginUser) {
        boolean flag = false;
        System.out.println(loginUser.getPassword()+"*******88"+passengerDao);
        Passenger user = passengerDao.findByPassword(loginUser.getPassword());
                              System.out.println(user.getUsername()+"*******88");
        if (user.getPassword().equals(loginUser.getPassword()) && user.getUsername().equals(loginUser.getUsername())) {
            flag = true;
        }

        return flag;
    }
}
