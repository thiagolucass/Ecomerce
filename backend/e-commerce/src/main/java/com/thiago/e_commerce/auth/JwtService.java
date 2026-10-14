package com.thiago.e_commerce.auth;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    private final SecretKey chave = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final long  tempoExpiracao = 1000 * 60 * 60;

    public String gerarToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+tempoExpiracao))
                .signWith(chave)
                .compact();
    }
    public String extrairEmail(String token) {
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
