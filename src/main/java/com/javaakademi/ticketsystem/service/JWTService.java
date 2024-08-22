package com.javaakademi.ticketsystem.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private String secretKey = "";

    public JWTService(){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sK = keyGenerator.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sK.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public static String extractUserName(String token) {
        return "";
    }

    //Token oluşturma işi bitti şuan giriş yapıldığında bize bir token üretiyor fakat auth için tokenle giriş yapamıyoruz
    //Bunun için validation gerekli
    public String generateToken(String username) {
        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 10)) //10 dakika olarak ayarladık exp süresini
                .and()
                .signWith(getKey())
                .compact();


    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
