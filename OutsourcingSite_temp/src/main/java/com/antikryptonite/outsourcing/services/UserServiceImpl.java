package com.antikryptonite.outsourcing.services;

import com.antikryptonite.outsourcing.converterdto.UserConverter;
import com.antikryptonite.outsourcing.dto.UserDto;
import com.antikryptonite.outsourcing.entityrepositorys.UserRepository;
import com.antikryptonite.outsourcing.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Релизация интерфейса сервиса БД пользователей
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Autowired
    UserConverter converter;

    @Override
    public UserDto postUser(UserDto userDto) {
        UserEntity userEntity = converter.dtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);
        return converter.entityToDto(userEntity);
    }

}
