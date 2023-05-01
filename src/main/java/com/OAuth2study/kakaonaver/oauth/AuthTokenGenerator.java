package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.authentication.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
// token 발급, jwtProvider에서 구현한 기능 실제로 주입받아서 구현 하는 클래스
public class AuthTokenGenerator {
    private static final String AUTH_HEADER = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME =  1000 * 60 * 30 ;// 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 30 * 24 * 7; //7일

    private final JwtTokenProvider jwtTokenProvider;

    public AuthToken generate(Long memberId){
        long now = (new Date()).getTime();

        Date accessTokenExpiredAt  = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiredAt = new Date (now +REFRESH_TOKEN_EXPIRE_TIME);

        String subject =  memberId.toString();
        String accessToken  = jwtTokenProvider.generateToken(subject,accessTokenExpiredAt);
        String refreshToken = jwtTokenProvider.generateToken(subject,refreshTokenExpiredAt);

        return AuthToken.generateAuthToken(accessToken,refreshToken,AUTH_HEADER,ACCESS_TOKEN_EXPIRE_TIME);

    }
    public Long extractMemberId(String accessToken){
        return Long.valueOf(jwtTokenProvider.extractToken(accessToken));
    }
}
