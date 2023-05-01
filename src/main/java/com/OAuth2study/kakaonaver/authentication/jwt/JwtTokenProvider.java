package com.OAuth2study.kakaonaver.authentication.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


// 토큰 발급, sub 추출,
@Component
public class JwtTokenProvider {
    private final Key key;

    public JwtTokenProvider(@Value("${jwt.secret-key}")String secretKey){
        byte[] decode = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(decode);
    }
    public String generateToken(String subject, Date expiredAt){
        return Jwts
                .builder()
                .setSubject(subject)
                .setExpiration(expiredAt)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    public String extractToken(String accessToken){
        Claims claims =parseClaims(accessToken);
        return claims.getSubject();
    }
    public Claims parseClaims(String accessToken) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken).getBody();
        }catch (ExpiredJwtException e){
            return e.getClaims();
        }
    }
}
