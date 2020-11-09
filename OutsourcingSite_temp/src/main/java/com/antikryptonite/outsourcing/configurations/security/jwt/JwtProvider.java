package com.antikryptonite.outsourcing.configurations.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Компонент для генерации и проверки JWT
 */
@Component
@Log
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.token.time}")
    private long validityInMilliseconds;

    /**
     * Геттер секретный ключ JWT?
     */
    public String getJwtSecret() {
        return jwtSecret;
    }

    /**
     * Геттер продолжительности работы токена
     */
    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }

    /**
     * Генерация токена
     *
     * @param login - Логин пользователя
     * @return - возвращает сгенерированный токен
     */
    public String generateToken(String login) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + getValidityInMilliseconds());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, getJwtSecret())
                .compact();
    }

    /**
     * Проверка на валидность токена
     *
     * @param token - проверяемый токен
     * @return - возвращает true или false, в зависимости от валидности токена
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.severe("Invalid token");
        }
        return false;
    }

    /**
     * Получение логина из токена
     *
     * @param token - токен, у которого требуется узнать логин
     * @return - логин
     */
    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
