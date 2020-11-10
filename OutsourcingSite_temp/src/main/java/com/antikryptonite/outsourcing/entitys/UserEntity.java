package com.antikryptonite.outsourcing.entitys;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * Сущность таблицы пользователей
 */
@Data
@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm")
    private boolean confirm;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private RoleEntity roleEntity;*/


}
