package com.example.googleoauthlogin.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenRefreshService {

    @Value("${AOP.test}")
    private int testnum;

    @RefreshTokenAnnotation
    public void test1() throws NeedRefreshException {

        throw new NeedRefreshException("refresh 가즈아");
    }

    @RefreshTokenAnnotation
    public void test2(Integer num, String string) throws NeedRefreshException {

        System.out.println("testnum : " +  testnum);
        System.out.println("num : " +  num);
        System.out.println("string : " +  string);

        testnum++;

        if(num == 2){
            throw new NeedRefreshException("refresh2 가즈아");
        }
    }
}
