package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.domain.OAuthProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RequestOAuthInfoService {
    //List<인터페이스> 를 주입받으면 해당 인터페이스의 구현체들이 전부 List 에 담겨온다.

    private final Map<OAuthProvider,OAuthApiClient> clients;

    public RequestOAuthInfoService(List<OAuthApiClient> clients){
        this.clients=clients.stream().collect(Collectors.toUnmodifiableMap(
                OAuthApiClient::oauthProvider, Function.identity())
        );
    }
    public OAuthInfoResponse request(OAuthLoginParams params){
        OAuthApiClient client = clients.get(params.oauthProvider());
        String accessToken = client.requestAccessToken(params);
        return client.requestOAuthInfoResponse(accessToken);
    }
}
