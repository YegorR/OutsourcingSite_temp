package com.antikryptonite.outsourcing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение на уникальность email
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User with this email already exists")
public class UniqueException extends RuntimeException {

}