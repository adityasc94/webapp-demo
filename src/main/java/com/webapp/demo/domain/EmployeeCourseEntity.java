package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_course", schema = "webapp")
public class EmployeeCourseEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity emp;

    @Column(name = "course_name", length = 100)
    private String courseName;

    @Column(name = "start_date", length = 100)
    private String startDate;

    @Column(name = "end_date", length = 100)
    private String endDate;

    @Column(name = "grading", length = 100)
    private String grading;

    @Column(name = "remarks", length = 100)
    private String remarks;

}