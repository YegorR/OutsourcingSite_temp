package com.antikryptonite.outsourcing.dto;

import lombok.*;

/**
 * Тело ответа аутентификации
 */
@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;

}
