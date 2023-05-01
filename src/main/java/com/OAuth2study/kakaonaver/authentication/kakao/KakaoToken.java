package com.OAuth2study.kakaonaver.authentication.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoToken {
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("refresh_token_expires_in")
    private Integer refreshTokenExpiresIn;
    @JsonProperty("scope")
    private String scope;
}
