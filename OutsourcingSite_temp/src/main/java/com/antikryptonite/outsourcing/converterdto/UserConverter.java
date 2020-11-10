package com.antikryptonite.outsourcing.converterdto;

import com.antikryptonite.outsourcing.dto.UserDto;
import com.antikryptonite.outsourcing.entitys.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвертер пользователей из entity в DTO и обратно
 */
@Component
public class UserConverter {

    public UserDto entityToDto(UserEntity userEntity) {
        ModelMapper mapper = new ModelMapper();
        UserDto map = mapper.map(userEntity, UserDto.class);
        return map;
    }

    public List<UserDto> entityToDto(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public UserEntity dtoToEntity(UserDto dto) {
        ModelMapper mapper = new ModelMapper();
        UserEntity map = mapper.map(dto, UserEntity.class);
        return map;
    }

    public List<UserEntity> dtoToEntity(List<UserDto> dto) {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
