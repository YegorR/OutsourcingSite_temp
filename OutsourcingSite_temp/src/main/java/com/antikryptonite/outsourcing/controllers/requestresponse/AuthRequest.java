package com.antikryptonite.outsourcing.controllers.requestresponse;

import lombok.Data;

/**
 * Тело запроса аутентификации
 */
@Data
public class AuthRequest {

    private String login;

    private String password;

}
