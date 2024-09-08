package com.sofca.historiaca.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";  // Cambia a una clave más segura

    // Genera un token JWT basado en un correo electrónico
    public String generateToken(String correo) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, correo);
    }

    // Crear token JWT con datos de usuario
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Expiración en 10 horas
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Obtener el correo del token JWT
    public String extractCorreo(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Validar si el token es correcto y no ha expirado
    public Boolean validateToken(String token, String correo) {
        final String correoToken = extractCorreo(token);
        return (correoToken.equals(correo) && !isTokenExpired(token));
    }

    // Obtener una reclamación de JWT
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Obtener todas las reclamaciones
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // Verificar si el token ha expirado
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Obtener la fecha de expiración del token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
