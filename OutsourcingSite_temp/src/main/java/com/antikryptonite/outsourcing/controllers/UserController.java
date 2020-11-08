package com.antikryptonite.outsourcing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер пользователя
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Проверка связи: по запросу http://localhost:8082/api/users/ping должен возвращаться pong
     *
     * @return "pong"
     */
    @GetMapping("/ping")
    public String ping() { return  "pong"; }

}
