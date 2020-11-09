package com.antikryptonite.outsourcing.services;

import com.antikryptonite.outsourcing.dto.RegistrationRequest;
import com.antikryptonite.outsourcing.entities.*;
import com.antikryptonite.outsourcing.exceptions.UniqueException;
import com.antikryptonite.outsourcing.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Сервис пользователя
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    /**
     * Конструктор сервиса
     */
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Сеттер PasswordEncoder
     */
    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Сохранение пользователя, присвоив ему роль по умолчанию
     *
     * @param registrationRequest - параметры пользователя
     */
    public void saveUser(RegistrationRequest registrationRequest) {
        if (userRepository.findByLogin(registrationRequest.getLogin()) != null) {
            throw new UniqueException();
        } else {
            UserEntity u = new UserEntity();
            RoleEntity userRole = roleRepository.findByName("ROLE_USER");
            u.setLogin(registrationRequest.getLogin());
            u.setId(UUID.randomUUID());
            u.setRoleEntity(userRole);
            u.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            userRepository.save(u);
        }
    }

    /**
     * Поиск пользователя по логину
     *
     * @param login - логин
     * @return - возвращает пользователя
     */
    public UserEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    /**
     * Поиск пользователя по логину и паролю для аутентификации
     *
     * @param login - логин пользователя
     * @param password - пароль пользователя
     * @return - возвращает найденного пользователя
     */
    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

}