package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_punishment", schema = "webapp")
public class EmployeePunishmentEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity emp;

    @Column(name = "punishment_awarded", length = 100)
    private String punishmentAwarded;

    @Column(name = "offence", length = 100)
    private String offence;

    @Column(name = "remarks", length = 100)
    private String remarks;

}