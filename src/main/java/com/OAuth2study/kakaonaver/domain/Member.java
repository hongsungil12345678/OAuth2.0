package com.OAuth2study.kakaonaver.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickname;
    private String gender;
    @Enumerated(EnumType.STRING)
    private OAuthProvider oauthProvider;

    @Builder
    public Member(String email,String nickname,String gender,OAuthProvider oauthProvider){
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.oauthProvider = oauthProvider;
    }

}
