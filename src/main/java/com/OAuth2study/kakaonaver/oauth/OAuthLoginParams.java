package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {
    OAuthProvider oauthProvider();
    MultiValueMap<String,String> parseBody();
}
