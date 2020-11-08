package com.antikryptonite.outsourcing.repositories;

import com.antikryptonite.outsourcing.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * Репозиторий пользователя
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Поиск пользователя по логину
     *
     * @param login - логин пользователя
     */
    UserEntity findByLogin(String login);

}