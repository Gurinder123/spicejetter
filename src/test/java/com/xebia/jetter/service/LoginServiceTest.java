package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerRepository;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by gurinder on 12/4/16.
 */
public class LoginServiceTest {

    @InjectMocks
    LoginService loginService = new LoginService();

    @Mock
    PassengerRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerifyLoginRequest() {
        LoginUser user = new LoginUser();
        user.setPassword("singh");
        user.setUsername("gsingh");
        Passenger passenger = new Passenger();
        passenger.setPassword("singh");
        passenger.setUsername("gsingh");

        when(repository.findByUsername("gsingh")).thenReturn(passenger);
        boolean result = loginService.verifyLoginRequest(user);
        assertEquals(true, result);
    }

}