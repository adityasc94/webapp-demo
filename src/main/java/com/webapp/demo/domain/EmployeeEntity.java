package com.webapp.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee", schema = "webapp")
public class EmployeeEntity {
    @Id
    @Column(name = "emp_id", nullable = false, length = 30)
    private String id;

    @Column(name = "emp_rank", length = 100)
    private String empRank;

    @Column(name = "trade", length = 100)
    private String trade;

    @Column(name = "emp_bty", length = 100)
    private String empBty;

    @Column(name = "emp_name", length = 100)
    private String empName;

    @Column(name = "father_name", length = 100)
    private String fatherName;

    @Column(name = "blood_group", length = 100)
    private String bloodGroup;

    @Column(name = "mother_name", length = 100)
    private String motherName;

    @Column(name = "bank_acc_num", length = 100)
    private String bankAccNum;

    @Column(name = "nok_details", length = 100)
    private String nokDetails;

    @Column(name = "pan_num", length = 100)
    private String panNum;

    @Column(name = "mobile_num_nok", length = 100)
    private String mobileNumNok;

    @Column(name = "mobile_num_own", length = 100)
    private String mobileNumOwn;

    @Column(name = "aadhaar_num", length = 100)
    private String aadhaarNum;

    @Column(name = "driving_lic_num", length = 100)
    private String drivingLicNum;

    @Column(name = "height", length = 100)
    private String height;

    @Column(name = "weight", length = 100)
    private String weight;

    @Column(name = "life_style_disease", length = 100)
    private String lifeStyleDisease;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name = "trade_cl", length = 100)
    private String tradeCl;

    @Column(name = "civ_qualification", length = 100)
    private String civQualification;

    @Column(name = "mr", length = 100)
    private String mr;

    @Column(name = "id_card_num", length = 100)
    private String idCardNum;

    @Column(name = "id_card_issuer", length = 100)
    private String idCardIssuer;

    @Column(name = "id_card_issue_date")
    private LocalDate idCardIssueDate;

    @Column(name = "leave_encashed", length = 100)
    private String leaveEncashed;

    @Column(name = "imp_appts_in_service", length = 100)
    private String impApptsInService;

    @Column(name = "hobbies", length = 100)
    private String hobbies;

    @Column(name = "civ_case", length = 100)
    private String civCase;

    @Column(name = "family_fued", length = 100)
    private String familyFued;

    @Column(name = "vehicle", length = 100)
    private String vehicle;

    @Column(name = "computer_knowledge", length = 100)
    private String computerKnowledge;

    @Column(name = "misc", length = 100)
    private String misc;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeCourseEntity> employeeCourseEntities = new ArrayList<>();

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeDutyEntity> employeeDutyEntities = new ArrayList<>();

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeSportEntity> employeeSportEntities = new ArrayList<>();

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeFamilyEntity> employeeFamilyEntities = new ArrayList<>();

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeePunishmentEntity> employeePunishmentEntities = new ArrayList<>();

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAddressEntity> employeeAddressEntities = new ArrayList<>();

}