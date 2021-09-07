package com.example.googleoauthlogin.controller;

import com.example.googleoauthlogin.dto.GoogleToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @GetMapping("/code")
    public String codeTaker(@RequestParam String code) throws UnirestException, JsonProcessingException {

        GoogleToken googleToken = tokenTaker(code);

        String who = emailGetter(googleToken.getAccess_token());

        return "code : " + code
                +"\n ========= token info : ===========" + googleToken
                + "\n ========== who : ==========" + who;
    }

    private GoogleToken tokenTaker(String code) throws UnirestException, JsonProcessingException {
        String client_id = "508138974042-3lp9vp9kqo37239hnlrhr0tbhvh5p6ca.apps.googleusercontent.com";
        String client_secret = "kx6-khx6EymYipLBXTuUELa_";
        String redirect_uri = "http://localhost:8080/code";
        String grant_type = "authorization_code";

        HttpResponse<String> response = Unirest.post("https://oauth2.googleapis.com/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("code", code)
                .field("client_id", client_id)
                .field("client_secret", client_secret)
                .field("redirect_uri", redirect_uri)
                .field("grant_type", grant_type)
                .asString();

        String body = response.getBody();
        GoogleToken googleToken = new ObjectMapper().readValue(body, GoogleToken.class);

        return googleToken;
    }

    private String emailGetter(String token) throws UnirestException {
        GetRequest getRequest = Unirest.get("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + token);
        HttpResponse<String> stringHttpResponse = getRequest.asString();

        return stringHttpResponse.getBody();
    }

}
