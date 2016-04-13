package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerRepository;
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
public class SpiceLogin implements LoginService {

    @Autowired
    private PassengerRepository passengerRepository;

    public boolean verifyLoginRequest(LoginUser loginUser) {
        boolean flag = false;
        Passenger user = passengerRepository.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword()) && user.getUsername().equals(loginUser.getUsername())) {
            flag = true;
        }

        return flag;
    }
}
