package com.OAuth2study.kakaonaver.oauth;

import com.OAuth2study.kakaonaver.authentication.kakao.KakaoLoginParams;
import com.OAuth2study.kakaonaver.authentication.naver.NaverLoginParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final OAuthLoginService oAuthLoginService;

    @PostMapping("/kakao")
    public ResponseEntity<AuthToken> loginKakao(@RequestBody KakaoLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

    @PostMapping("/naver")
    public ResponseEntity<AuthToken> loginNaver(@RequestBody NaverLoginParams params) {
        return ResponseEntity.ok(oAuthLoginService.login(params));
    }

}
