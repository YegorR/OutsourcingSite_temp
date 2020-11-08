package com.antikryptonite.outsourcing.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "user_table")
@Data
public class UserEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

}