package com.antikryptonite.outsourcing.controllers;

import com.antikryptonite.outsourcing.configurations.security.jwt.JwtProvider;
import com.antikryptonite.outsourcing.dto.AuthRequest;
import com.antikryptonite.outsourcing.dto.AuthResponse;
import com.antikryptonite.outsourcing.dto.RegistrationRequest;
import com.antikryptonite.outsourcing.entities.UserEntity;
import com.antikryptonite.outsourcing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Контроллер регистрации и аутентификации
 */
@RestController
public class AuthController {

    // TODO: @autowired не делаем к переменным, только к сеттерам или конструкторам
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * POST-запрос на регистрацию
     *
     * @param registrationRequest - тело запроса с логином и паролем
     * @return - возвращает строку ОК, хотя я думаю надо токен сразу возвращать? пользователь же сразу после регистрации заходит в свой акк, или ему еще надо подтвердить регистроцию на почте?
     * TODO: 1) нужно подтвердить через email 2) токен не надо возввращать, в любом случае после регистрации пользователь должен ещё раз ввести свои данные
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        //TODO: работу с entity выносим в сервисы
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());

        u.setId(UUID.randomUUID());

        userService.saveUser(u);
        return "OK";
    }

    /**
     * POST-запрос на аутентификацию
     *
     * @param request - тело запроса с логином и паролем
     * @return - возвращает уникальный токен пользователя
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        //TODO вынести всё в отдельный сервис
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }

}
