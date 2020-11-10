package com.antikryptonite.outsourcing.controllers;

import com.antikryptonite.outsourcing.dto.UserDto;
import com.antikryptonite.outsourcing.entityrepositorys.UserRepository;
import com.antikryptonite.outsourcing.entitys.UserEntity;
import com.antikryptonite.outsourcing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Контроллер пользователя
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    /**
     * Создание нового пользователя: по запросу http://localhost:8082/api/users/post с указанием полей в body добавляется новый пользователь
     *
     */
    @PostMapping("/post")
    public UserDto postUser(@RequestBody UserDto userDto ) { return userService.postUser(userDto); }

    /**
     * Проверка связи: по запросу http://localhost:8082/api/users/ping должен возвращаться pong
     *
     * @return "pong"
     */
    @GetMapping("/ping")
    public String ping() { return  "pong"; }

}
