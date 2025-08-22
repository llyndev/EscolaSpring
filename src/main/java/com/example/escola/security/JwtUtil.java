package com.example.escola.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Chave secreta usada para assinar e validar os tokens JWT (exposta apenas para testes).
    private final String SECRET = "ZlK9s7D3pQx4rA8wN2tY5uH1eC6bJ0mQvX9zT4rW8kF1gS7dL2nP5hR8tU0aV6x";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Tempo de expiração do token em milissegundos (12 horas).
    private final long EXPIRATION_MS = 1000 * 60 * 60 * 12;

    // Gera um token JWT para o e-mail informado, definindo data de emissão,
    // expiração e assinatura digital com a chave secreta.
    public String generateToken(String email) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }

    // Extrai o e-mail do token JWT (armazenado como 'subject' no payload).
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Valida o token JWT verificando sua assinatura e data de expiração.
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return  true;
        } catch (ExpiredJwtException exception) {
            System.out.println("Token expirado!");
            return false;
        } catch (JwtException | IllegalArgumentException exception) {
            System.out.println("Token invalido!");
            return false;
        }
    }
}
