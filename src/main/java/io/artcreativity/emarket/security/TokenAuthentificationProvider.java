package io.artcreativity.emarket.security;

import io.artcreativity.emarket.payload.JwtAuthenticationResponse;
import io.jsonwebtoken.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class TokenAuthentificationProvider {

	private static final Logger logger = LoggerFactory.getLogger(TokenAuthentificationProvider.class);

    @Value("${jwt.jwtSecret}")
    private String jwtSecret;
    @Value("${jwt.jwtExpirationInMs}")
    private long jwtExpirationInMs;
    

	public /*String*/ Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token)
                .getBody();

		return Long.parseLong(claims.getSubject());/* claims.getSubject(); */
    }
	
	public JwtAuthenticationResponse generateToken(Authentication authentication) {
        return generateToken((UserPrincipal) authentication.getPrincipal());
    }
	
	public JwtAuthenticationResponse generateToken(UserPrincipal userDetails) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        Map<String, Object> claims = new HashMap<>();
        List<String> roles = new ArrayList<>();
        userDetails.getAuthorities().forEach(role -> {
        	roles.add(role.getAuthority());
        });
        claims.put("roles", roles.toArray(new String[0]));

        // JWT for authentication
        String token = Jwts.builder()                
                .setClaims(claims)
                .setSubject(userDetails.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
       
        return new JwtAuthenticationResponse(token, expiryDate);
    }

    public boolean validateToken(String authToken) {
        return validateJWT(authToken, jwtSecret);
    }

    private boolean validateJWT(String authToken, String jwtRefreshSecret) {
        try {
            Jwts.parser().setSigningKey(jwtRefreshSecret.getBytes()).parseClaimsJws(authToken);
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
        }
        return false;
    }
}
