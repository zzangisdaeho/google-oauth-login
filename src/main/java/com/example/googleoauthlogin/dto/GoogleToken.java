package com.example.googleoauthlogin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoogleToken {
    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
    private String id_token;
}
