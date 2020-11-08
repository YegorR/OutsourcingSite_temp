package com.antikryptonite.OutsourcingSite_temp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер пользователя
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/ping")
    public String ping() { return  "pong"; }

}
