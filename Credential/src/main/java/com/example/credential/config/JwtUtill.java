package com.example.credential.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtill {

    private String secret = "123456";

    public static final long JWT_TOKEN_VALIDITY = 1800000;

    public String getUsernameFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parser().
                setSigningKey(secret).
                parseClaimsJws(token).
                getBody();
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(getUsernameFromToken(token)) && !isexpToken(token));
    }


    public boolean isexpToken(String token) {
        return expDate(token).before(new Date(System.currentTimeMillis()));
    }


    public Date expDate(String token) {
        return getClaims(token).getExpiration();
    }

    public String doGenerateToken(String subject) {
        System.out.println("Genetare Token");
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

//    public static void main(String[] args) {
//        JwtUtill jwtUtill = new JwtUtill();
//        System.out.println(jwtUtill.getUsernameFromToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvcmcuc3ByaW5nZnJhbWV3b3JrLnNlY3VyaXR5LmNvcmUudXNlcmRldGFpbHMuVXNlciBbVXNlcm5hbWU9YW5jQGdtYWlsLmNvbSwgUGFzc3dvcmQ9W1BST1RFQ1RFRF0sIEVuYWJsZWQ9dHJ1ZSwgQWNjb3VudE5vbkV4cGlyZWQ9dHJ1ZSwgY3JlZGVudGlhbHNOb25FeHBpcmVkPXRydWUsIEFjY291bnROb25Mb2NrZWQ9dHJ1ZSwgR3JhbnRlZCBBdXRob3JpdGllcz1bUk9MRV9WZW5kb3JdXSIsImlhdCI6MTY1MDQzMzc2OCwiZXhwIjoxNjUwNDUxNzY4fQ.xEKsOvxx_Phn03o4-MZNU7Zo6K798wdfBgBoy-McEh4"));
//    }
}
