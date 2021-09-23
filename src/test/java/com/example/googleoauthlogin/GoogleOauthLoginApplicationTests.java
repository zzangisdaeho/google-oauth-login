package com.example.googleoauthlogin;

import com.example.googleoauthlogin.aop.NeedRefreshException;
import com.example.googleoauthlogin.aop.RefreshTokenAnnotation;
import com.example.googleoauthlogin.aop.TokenRefreshService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoogleOauthLoginApplicationTests {

    @Autowired
    private TokenRefreshService tokenRefreshService;

//    @Test
//    void test1() throws NeedRefreshException {
//        tokenRefreshService.test1();
////        Assertions.assertThrows(NeedRefreshException.class, ()->  tokenRefreshService.test());
//    }
//
//    @Test
//    void test2() throws NeedRefreshException {
//        tokenRefreshService.test2(2, "2");
//    }
}
