package com.antikryptonite.outsourcing.configurations.security;

import com.antikryptonite.outsourcing.entities.UserEntity;
import com.antikryptonite.outsourcing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;

/**
 * Это сервис предыдущего ДТО? TODO: это условно говоря сервис для получения учетных данных пользователя
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired  //TODO: сеттер или конструктор
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
