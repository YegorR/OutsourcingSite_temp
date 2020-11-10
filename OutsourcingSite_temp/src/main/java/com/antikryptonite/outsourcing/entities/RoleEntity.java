package com.antikryptonite.outsourcing.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

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
    private UUID id;

    @Column(name = "name")
    private String name;

}
