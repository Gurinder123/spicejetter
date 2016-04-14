package com.xebia.jetter;

import com.xebia.jetter.controller.LoginController;
import com.xebia.jetter.dao.PassengerRepository;
import com.xebia.jetter.domain.request.ResponseStatus;
import com.xebia.jetter.enums.Status;
import com.xebia.jetter.model.LoginUser;
import com.xebia.jetter.model.Passenger;
import com.xebia.jetter.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by gurinder on 13/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@SpringApplicationConfiguration(classes = SpicesuggestApplication.class)
public class LoginControllerTest {

    @Value("${local.server.port}")
    private int port;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PassengerRepository repository;
    @Autowired
    private LoginController loginController;

    private RestTemplate template;


    public LoginControllerTest() {
        template = new RestTemplate();
    }

    @Test
    public void testShouldVerifyLoginRequest() {
        Passenger user = getPassenger();
        repository.save(user);
        String url = "http://localhost:" + port + "/spice/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LoginUser loginUser = new LoginUser("testuser", "test");
        ResponseStatus responseStatus = template.postForObject(url, loginUser, ResponseStatus.class);
        assertEquals(Status.SUCCESS, responseStatus.getStatus());
        assertEquals("login success", responseStatus.getMessage());

        repository.delete(user);
    }

    private Passenger getPassenger() {
        Passenger user = new Passenger();
        user.setUsername("testuser");
        user.setPassword("test");
        return user;
    }
}
