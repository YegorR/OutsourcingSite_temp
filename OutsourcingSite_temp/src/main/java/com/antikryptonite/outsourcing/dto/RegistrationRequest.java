package com.antikryptonite.outsourcing.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Тело запроса на регистрацию
 */
@Data
public class RegistrationRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

}