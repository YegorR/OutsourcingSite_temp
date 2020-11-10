package com.antikryptonite.outsourcing.repositories;

import com.antikryptonite.outsourcing.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозиторий пользователя
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Поиск пользователя по логину
     * @param login - логин пользователя
     */
    UserEntity findByLogin(String login);

    /**
     * Поиск пользователя по его личному номеру
     * @param confirmRegistration - личный номер пользователя
     */
    UserEntity findByConfirmRegistration(String confirmRegistration);
}