package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_sport", schema = "webapp")
public class EmployeeSportEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity emp;

    @Column(name = "sport_played", length = 100)
    private String sportPlayed;

    @Column(name = "sport_level", length = 100)
    private String sportLevel;

    @Column(name = "remarks", length = 100)
    private String remarks;

}