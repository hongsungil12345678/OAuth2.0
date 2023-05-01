package com.OAuth2study.kakaonaver.authentication.kakao;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import com.OAuth2study.kakaonaver.oauth.OAuthInfoResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoInfoResponse implements OAuthInfoResponse {
    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoAccount{
        private KakaoProfile profile;
        private String email;
        private String gender;
    }
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class KakaoProfile{
        private String nickname;
    }

    @Override
    public String getEmail() {
        return kakaoAccount.email;
    }

    @Override
    public String getNickName() {
        return kakaoAccount.profile.nickname;
    }

    @Override
    public String getGender() {
        return kakaoAccount.gender;
    }

    @Override
    public OAuthProvider getOAuthProvider() {
        return OAuthProvider.KAKAO;
    }
}
