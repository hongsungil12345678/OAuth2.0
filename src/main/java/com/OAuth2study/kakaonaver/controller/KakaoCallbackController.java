package com.OAuth2study.kakaonaver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kakao")
public class KakaoCallbackController {
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code){
        return code;
    }
}
