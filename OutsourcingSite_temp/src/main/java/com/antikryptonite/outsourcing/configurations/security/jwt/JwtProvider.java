package com.antikryptonite.outsourcing.configurations.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.Date;

/**
 * JSON Web Token чего???
 */
@Component
@Log
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    /**
     * Генерация токена
     *
     * @param login - Логин пользователя
     * @return - возвращает сгенерированный токен
     */
    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
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
