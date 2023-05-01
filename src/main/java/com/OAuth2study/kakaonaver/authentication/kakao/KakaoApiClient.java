package com.OAuth2study.kakaonaver.authentication.kakao;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import com.OAuth2study.kakaonaver.oauth.OAuthApiClient;
import com.OAuth2study.kakaonaver.oauth.OAuthInfoResponse;
import com.OAuth2study.kakaonaver.oauth.OAuthLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class KakaoApiClient implements OAuthApiClient {
    static final String GRANT_TYPE="authorization_code";
    @Value("${oauth.kakao.client-id}")
    private String clientId;
    @Value("${oauth.kakao.url.auth}")
    private String authUrl;
    @Value("${oauth.kakao.url.api}")
    private String apiUrl;
    private final RestTemplate restTemplate;

    @Override
    public OAuthProvider oauthProvider() {
        return OAuthProvider.KAKAO;
    }

    //authURl = https://kauth.kakao.com
    @Override
    public String requestAccessToken(OAuthLoginParams params) {
        String url = authUrl+"/oauth/token";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = params.parseBody();
        body.add("grant_type",GRANT_TYPE);
        body.add("client_id",clientId);

       HttpEntity<?> request = new HttpEntity<>(body,httpHeaders);
        // 요청 결과값을 KakaoToken을 통해서 받아옴
        KakaoToken response= restTemplate.postForObject(url,request,KakaoToken.class);
        assert response != null;// response 값이 null 이면 안됨
        // accesstoken 반환
        return response.getAccessToken();
    }
//accesstoken을 통해서 유저 정보 받아옴
    @Override
    public OAuthInfoResponse requestOAuthInfoResponse(String accessToken) {
        String url = apiUrl+"/v2/user/me";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add("Authorization","Bearer "+accessToken);

        MultiValueMap<String, String> body= new LinkedMultiValueMap<>();
        body.add("property_keys","[\"kakao_account.email\",\"kakao_account.gender\",\"kakao_account.profile\"]");

        HttpEntity<?> request = new HttpEntity<>(body,httpHeaders);

        KakaoInfoResponse response = restTemplate.postForObject(url, request, KakaoInfoResponse.class);
        assert response != null;

        return response;
    }
}
