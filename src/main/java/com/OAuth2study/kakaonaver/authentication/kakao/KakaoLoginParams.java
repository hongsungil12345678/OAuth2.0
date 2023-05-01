package com.OAuth2study.kakaonaver.authentication.kakao;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import com.OAuth2study.kakaonaver.oauth.OAuthLoginParams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@NoArgsConstructor
public class KakaoLoginParams implements OAuthLoginParams {
    private String authorizationCode;
    @Override
    public OAuthProvider oauthProvider() {
        return OAuthProvider.KAKAO;
    }

    @Override
    public MultiValueMap<String, String> parseBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code",authorizationCode);
        return body;
    }
}
