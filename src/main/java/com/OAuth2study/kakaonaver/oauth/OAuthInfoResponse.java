package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickName();
    String getGender();
    OAuthProvider getOAuthProvider();
}
