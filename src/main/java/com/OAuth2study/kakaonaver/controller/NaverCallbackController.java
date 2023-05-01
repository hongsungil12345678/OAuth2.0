package com.OAuth2study.kakaonaver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naver")
public class NaverCallbackController {
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state")String state){
        return "Code :"+code+"  State :"+state;
    }
}