package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;

public interface OAuthApiClient {
    OAuthProvider oauthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOAuthInfoResponse(String accessToken);
}
