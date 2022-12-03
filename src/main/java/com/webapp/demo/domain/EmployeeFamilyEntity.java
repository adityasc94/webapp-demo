package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_family", schema = "webapp")
public class EmployeeFamilyEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_name", length = 100)
    private String memberName;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "age", length = 50)
    private String age;

    @Column(name = "qualification", length = 100)
    private String qualification;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity emp;

}