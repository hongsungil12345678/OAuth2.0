package com.OAuth2study.kakaonaver.controller;

import com.OAuth2study.kakaonaver.domain.Member;
import com.OAuth2study.kakaonaver.oauth.AuthTokenGenerator;
import com.OAuth2study.kakaonaver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final AuthTokenGenerator authTokenGenerator;

    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        return ResponseEntity.ok(memberRepository.findAll());
    }

    @GetMapping("/{accessToken}")
    public ResponseEntity<Member> findByAccessToken(@PathVariable String accessToken) {
        Long memberId = authTokenGenerator.extractMemberId(accessToken);
        return ResponseEntity.ok(memberRepository.findById(memberId).get());
    }
}
