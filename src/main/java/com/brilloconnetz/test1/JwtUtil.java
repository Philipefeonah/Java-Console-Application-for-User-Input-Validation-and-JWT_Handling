package com.brilloconnetz.test1;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateJwtToken(String username, String email, String password) {
        return Jwts.builder()
                .setSubject(username)
                .claim("email", email)
                .claim("password", password)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String verifyJwtToken(String jwt, String expectedUsername, String expectedEmail, String expectedPassword) {
        try {
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(jwt);

            Claims claims = jws.getBody();


            Date expiration = claims.getExpiration();

            if (expiration != null && expiration.before(new Date())) {
                return "Verification fails: Token expired";
            }

            String username = claims.getSubject();
            String email = claims.get("email", String.class);
            String password = claims.get("password", String.class);

            if (username == null || email == null) {
                return "Verification fails: Missing username or email";
            }

            if (!username.equals(expectedUsername)) {
                return "Verification fails: Username does not match expected value";
            }

            if (!email.equals(expectedEmail)) {
                return "Verification fails: Email does not match expected value";
            }

            if (!password.equals(expectedPassword)) {
                return "Verification fails: Password does not match expected value";
            }

            return "Verification pass";

        } catch (Exception e) {
            return "Verification fails";
        }

    }
}
