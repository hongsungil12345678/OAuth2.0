package com.OAuth2study.kakaonaver.authentication.naver;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import com.OAuth2study.kakaonaver.oauth.OAuthInfoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverInfoResponse implements OAuthInfoResponse {

    @JsonProperty("response")
    private Response response;
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Response{
        private String email;
        private String nickname;
        private String gender;
    }
    @Override
    public String getEmail() {
        return response.email;
    }

    @Override
    public String getNickName() {
        return response.nickname;
    }

    @Override
    public String getGender() {
        return response.gender;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.NAVER;
    }
}
