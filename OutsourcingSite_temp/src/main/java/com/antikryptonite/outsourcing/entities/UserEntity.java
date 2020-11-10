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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "inn_number")
    private String innNumber;

    @Column(name = "confirm_registration")
    private String confirmRegistration;

    @Column(name = "confirm")
    private boolean confirm;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

}