package com.antikryptonite.outsourcing.dto;

import lombok.Data;

/**
 * Тело запроса аутентификации
 */
@Data
public class AuthRequest {

    private String login;

    private String password;

}
