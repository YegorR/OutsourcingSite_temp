package com.antikryptonite.outsourcing.services;

import com.antikryptonite.outsourcing.configurations.security.jwt.JwtProvider;
import com.antikryptonite.outsourcing.dto.*;
import com.antikryptonite.outsourcing.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис аутентификации
 */
@Service
public class AuthService {

    private final UserService userService;

    private final JwtProvider jwtProvider;

    /**
     * Конструктор сервиса
     */
    @Autowired
    public AuthService(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    /**
     * Получение токена по логину
     *
     * @param request - параметры пользователя
     * @return - возвращает найденный токен по логину
     */
    public AuthResponse giveToken(AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }

}
