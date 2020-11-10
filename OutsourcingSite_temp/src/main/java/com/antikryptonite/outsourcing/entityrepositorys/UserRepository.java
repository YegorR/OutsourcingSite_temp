package com.antikryptonite.outsourcing.entityrepositorys;

import com.antikryptonite.outsourcing.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий пользователя
 */
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
