package com.antikryptonite.outsourcing.repositories;

import com.antikryptonite.outsourcing.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий роли
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    /**
     * Поиск роли по имени
     *
     * @param name - имя роли
     */
    RoleEntity findByName(String name);

}