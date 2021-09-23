package com.example.googleoauthlogin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class LoginService {

    @Value("classpath:/client_secret_test.json")
    private Resource jsons;

//    @GetMapping("/code")
//    public GoogleAuthorizationCodeFlow test() throws IOException {
//        GoogleAuthorizationCodeFlow offline = new GoogleAuthorizationCodeFlow.Builder(
//                new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
//                "508138974042-3lp9vp9kqo37239hnlrhr0tbhvh5p6ca.apps.googleusercontent.com",
//                "kx6-khx6EymYipLBXTuUELa_",
//                List.of(DriveScopes.DRIVE, CalendarScopes.CALENDAR))
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
//                .setAccessType("offline")
////                .setTokenServerUrl(GenericUrl.toPathParts("https://oauth2.googleapis.com/token"))
//                .build();
//
//
//
//        return offline;

//    }

//    @GetMapping("/code")
//    public void test2() throws IOException {
//        GoogleCredentials credentials = GoogleCredentials.fromStream(jsons.getInputStream());
//        credentials.refreshIfExpired();
//        AccessToken token = credentials.getAccessToken();
//// OR
//        AccessToken token2 = credentials.refreshAccessToken();
//    }
}
