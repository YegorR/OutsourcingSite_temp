package com.antikryptonite.outsourcing.entities;

import lombok.Data;
import javax.persistence.*;

/**
 * Сущность роли
 */
@Entity
@Table(name = "role_table")
@Data
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    private String name;

}
