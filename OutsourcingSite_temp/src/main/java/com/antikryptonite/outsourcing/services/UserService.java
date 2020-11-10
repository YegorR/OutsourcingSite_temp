package com.antikryptonite.outsourcing.services;

import com.antikryptonite.outsourcing.dto.UserDto;

/**
 * Интерфейс сервиса БД пользователей
 */
public interface UserService {

    UserDto postUser(UserDto userDto);

}
