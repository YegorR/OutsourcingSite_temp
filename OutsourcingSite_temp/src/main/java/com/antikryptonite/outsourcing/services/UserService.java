package com.antikryptonite.outsourcing.services;

import com.antikryptonite.outsourcing.entities.*;
import com.antikryptonite.outsourcing.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Сервис пользователя
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /** может сделать этот метод void?
     * Сохранение пользователя, присвоив ему роль по умолчанию
     *
     * @param userEntity - параметры пользователя
     * @return - сохраняет пользователя
     */
    public UserEntity saveUser(UserEntity userEntity) {
        RoleEntity userRole = roleRepository.findByName("ROLE_USER");
        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
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
