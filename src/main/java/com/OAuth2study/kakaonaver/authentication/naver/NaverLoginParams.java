package com.OAuth2study.kakaonaver.authentication.naver;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import com.OAuth2study.kakaonaver.oauth.OAuthLoginParams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@NoArgsConstructor
public class NaverLoginParams implements OAuthLoginParams {
    private String authorizationCode;
    private String state;
    @Override
    public OAuthProvider oauthProvider() {
        return OAuthProvider.NAVER;
    }

    @Override
    public MultiValueMap<String, String> parseBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code",authorizationCode);
        body.add("state",state);
        return body;
    }
}
