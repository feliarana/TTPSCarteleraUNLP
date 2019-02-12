package com.cartelera.infocarteapi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.util.Date;


@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private SecretKey jwtSecret = MacProvider.generateKey(SignatureAlgorithm.HS256);
    private String base64Encoded = TextCodec.BASE64.encode(jwtSecret.getEncoded());

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) throws UnsupportedEncodingException {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        System.out.println("EXPIRACION: " + expiryDate);

        System.out.println("SECRET: " + jwtSecret);
        System.out.println("base64: " + base64Encoded);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, base64Encoded.getBytes("UTF-8"))
                .compact();
    }

    public Long getUserIdFromJWT(String token) throws UnsupportedEncodingException {
        Claims claims = Jwts.parser()
                .setSigningKey(base64Encoded.getBytes("UTF-8"))
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(base64Encoded.getBytes("UTF-8")).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      return false;
    }
}
