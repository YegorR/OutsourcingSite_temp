package com.antikryptonite.outsourcing.controllers;

import com.antikryptonite.outsourcing.dto.AuthRequest;
import com.antikryptonite.outsourcing.dto.AuthResponse;
import com.antikryptonite.outsourcing.dto.RegistrationRequest;
import com.antikryptonite.outsourcing.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Контроллер регистрации и аутентификации
 */
@RestController
public class AuthController {

    private final UserService userService;

    private final AuthService authService;

    /**
     * Конструктор контроллера
     */
    @Autowired
    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    /**
     * POST-запрос на регистрацию
     * http://localhost:8082/api/register
     * @param registrationRequest - тело запроса с логином и паролем
     * @return - возвращает строку ОК
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        userService.saveUser(registrationRequest);
        return "OK";
    }

    /**
     * POST-запрос на аутентификацию
     * http://localhost:8082/api/auth
     * @param request - тело запроса с логином и паролем
     * @return - возвращает уникальный токен пользователя
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        return authService.giveToken(request);
    }

}
