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
@Table(name = "project")
@Data
public class ProjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private long projectId;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;
}
