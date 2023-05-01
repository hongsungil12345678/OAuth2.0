package com.OAuth2study.kakaonaver.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {
    private String accessToken;
    private String refreshToken;
    private String grantType;
    private Long expiredIn;

    public static AuthToken generateAuthToken(String accessToken,String refreshToken,String grantType,Long expiredIn){
        return new AuthToken(accessToken, refreshToken, grantType, expiredIn);
    }
}
