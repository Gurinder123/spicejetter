package com.xebia.jetter.service;

import com.xebia.jetter.dao.PassengerRepository;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import com.xebia.jetter.utils.DateUtil;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by gurinder on 12/4/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DateUtil.class)
@NoArgsConstructor
public class SpiceLoginPowerTest {

    @Mock
    PassengerRepository repository;

    @Mock
    DateUtil util;

    @InjectMocks
    LoginService loginService = new SpiceLogin(repository);


    private LoginUser loginUser;
    private boolean result;

    @Before
    public void init() {
        PowerMockito.mockStatic(DateUtil.class);
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testShouldVerifyLoginRequest() {
        LoginUser user = new LoginUser();
        user.setPassword("singh");
        user.setUsername("gsingh");

        Passenger passenger = new Passenger();
        passenger.setPassword("singh");
        passenger.setUsername("gsingh");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        when(DateUtil.getCurrentDate()).thenReturn(yesterday);

        doReturn(passenger).when(repository).findByUsername("gsingh");
        boolean result = loginService.verifyLoginRequest(user);
        assertEquals(result, result);
    }

}