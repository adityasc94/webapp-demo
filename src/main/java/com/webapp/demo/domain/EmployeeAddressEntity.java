package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee_address", schema = "webapp")
public class EmployeeAddressEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_id", nullable = false)
    private EmployeeEntity emp;

    @Column(name = "address_type", nullable = false, length = 1)
    private String addressType;

    @Column(name = "village", length = 100)
    private String village;

    @Column(name = "post", length = 100)
    private String post;

    @Column(name = "tehsil", length = 100)
    private String tehsil;

    @Column(name = "district", length = 100)
    private String district;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "pin", length = 10)
    private String pin;

}