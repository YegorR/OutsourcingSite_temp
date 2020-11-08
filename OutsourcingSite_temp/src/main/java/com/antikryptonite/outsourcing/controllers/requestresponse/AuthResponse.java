package com.antikryptonite.outsourcing.controllers.requestresponse;

import lombok.*;

/**
 * Тело ответа аутентификации
 */
@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;

}
