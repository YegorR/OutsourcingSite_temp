package com.antikryptonite.outsourcing.repositories;

import com.antikryptonite.outsourcing.entities.RoleEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий роли
 */
@Repository
@EntityScan(basePackages = {"com.antikryptonite.outsourcing.entities.RoleEntity"})
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    /**
     * Поиск роли по имени
     *
     * @param name - имя роли
     */
    RoleEntity findByName(String name);

}