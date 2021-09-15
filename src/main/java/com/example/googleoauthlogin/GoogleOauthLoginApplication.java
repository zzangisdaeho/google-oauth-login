package com.example.googleoauthlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GoogleOauthLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleOauthLoginApplication.class, args);
    }

}
