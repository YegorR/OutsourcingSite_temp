package com.antikryptonite.outsourcing.controllers;

import com.antikryptonite.outsourcing.dto.*;
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
     * @param registrationRequest - тело запроса с логином и паролем
     * @return - возвращает строку ОК
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        userService.saveUser(registrationRequest);
        return "OK";
    }

    /**
     * GET-запрос на подтверждение аккаунта
     * @param code - личный номер пользователя
     * @return - возвращает строку об успешном подтверждении аккаунта
     */
    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code) {
        return userService.activateUser(code);
    }
//    @GetMapping("/activate/{code}")
//    public String activate(@PathVariable String code) {
//        userService.activateUser(code);
//        return "You are activated!";
//    }

    /**
     * POST-запрос на аутентификацию
     * @param request - тело запроса с логином и паролем
     * @return - возвращает уникальный токен пользователя
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        return authService.giveToken(request);
    }

}
