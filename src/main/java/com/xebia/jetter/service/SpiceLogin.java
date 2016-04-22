package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerRepository;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import com.xebia.jetter.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: HJAIN
 * Date: 4/9/16
 * Time: 2:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SpiceLogin implements LoginService {


    private PassengerRepository passengerRepository;

    @Autowired
    private DateUtil util;

    @Autowired
    public SpiceLogin(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public boolean verifyLoginRequest(LoginUser loginUser) {
        boolean flag = false;
        Passenger user = passengerRepository.findByUsername(loginUser.getUsername());
        Date currentDate = util.getCurrentDate();

        if (currentDate != null && user != null && user.getPassword().equals(loginUser.getPassword())
                && user.getUsername().equals(loginUser.getUsername())) {
            flag = true;
        }

        return flag;
    }
}
