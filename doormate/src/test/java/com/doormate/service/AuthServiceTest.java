package com.doormate.service;

import com.doormate.DoormateApplication;
import com.doormate.security.jwt.payload.request.LoginRequest;
import com.doormate.security.jwt.payload.response.TokenResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DoormateApplication.class)
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Test
    public void testSuccessGenerateAccessTokenAndRefreshToken() throws Exception {
        LoginRequest request = LoginRequest.builder()
                .username("admin")
                .password("admin")
                .build();

        TokenResponse tokenResponse = authService.generateAccessTokenAndRefreshToken(request);
        Assert.assertNotNull(tokenResponse);
    }

    @Test
    public void testDeleteTokenFromUsername() {
        authService.deleteTokenFromUsername("strongcom");
    }
}