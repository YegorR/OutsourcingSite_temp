package com.antikryptonite.outsourcing.repositories;

import com.antikryptonite.outsourcing.entities.UserEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий пользователя
 */
@Repository
@EntityScan(basePackages = {"com.antikryptonite.outsourcing.entities.UserEntity"})
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Поиск пользователя по логину
     *
     * @param login - логин пользователя
     */
    UserEntity findByLogin(String login);

}