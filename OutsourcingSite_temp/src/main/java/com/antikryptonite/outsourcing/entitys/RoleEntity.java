package com.antikryptonite.outsourcing.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Сущность таблицы ролей
 */
@Data
@Entity
@Table(name = "role_table")
public class RoleEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "roleEntity")
    private List<UserEntity> userEntityList = new ArrayList<>();*/


}
