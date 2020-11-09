package com.antikryptonite.outsourcing.configurations.security;

import com.antikryptonite.outsourcing.entities.UserEntity;
import com.antikryptonite.outsourcing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

/**
 * Сервис для получения учетных данных пользователя
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    /**
     * Конструктор сервиса для получения учетных данных пользователя
     */
    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
