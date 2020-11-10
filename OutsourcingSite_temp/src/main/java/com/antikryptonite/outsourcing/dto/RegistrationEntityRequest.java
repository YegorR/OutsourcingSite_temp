package com.antikryptonite.outsourcing.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

/**
 * Тело запроса на регистрацию юридического лица
 */
@Data
public class RegistrationEntityRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String orgName;

    @NotEmpty
    private String innNumber;

}