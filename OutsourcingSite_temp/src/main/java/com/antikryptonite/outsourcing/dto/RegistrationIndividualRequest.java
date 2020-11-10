package com.antikryptonite.outsourcing.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

/**
 * Тело запроса на регистрацию физического лица
 */
@Data
public class RegistrationIndividualRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String middleName;

    @NotEmpty
    private String innNumber;

}