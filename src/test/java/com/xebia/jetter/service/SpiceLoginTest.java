package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerRepository;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * Created by gurinder on 12/4/16.
 */
@RunWith(Parameterized.class)
public class SpiceLoginTest {

    @Mock
    PassengerRepository repository;

    @InjectMocks
    LoginService loginService = new SpiceLogin(repository);


    private LoginUser loginUser;
    private boolean result;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    public SpiceLoginTest(LoginUser loginUser, boolean result) {
        this.loginUser = loginUser;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new LoginUser("gsingh", "password"), true},
                {new LoginUser("gsingh1", "password"), false}}
        );
    }

    @Test
    public void testShouldVerifyLoginRequest() {
        LoginUser user = new LoginUser();
        user.setPassword("singh");
        user.setUsername("gsingh");
        Passenger passenger = new Passenger();
        passenger.setPassword("singh");
        passenger.setUsername("gsingh");
//        when(repository.findByUsername("gsingh")).thenReturn(passenger);
        doReturn(passenger).when(repository).findByUsername("gsingh");
        boolean result = loginService.verifyLoginRequest(loginUser);
        assertEquals(result, result);
    }

}