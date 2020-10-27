package com.cistem.constructionerp.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Deshala Mendis
 * @version 1.0
 * @since 09.10.2020
 */
@Entity
@Table(name = "user_role")
@Data
public class UserRoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

}
