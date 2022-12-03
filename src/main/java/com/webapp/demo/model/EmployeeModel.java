package com.webapp.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.webapp.demo.util.Constants.DATE_FORMAT_1;

@Data
public class EmployeeModel {

	@JsonProperty("fatherName")
	private String fatherName;

	@JsonProperty("panNum")
	private String panNum;

	@JsonProperty("employeeDuties")
	private List<EmployeeDutyModel> employeeDuties = new ArrayList<>();

	@JsonProperty("tradeCl")
	private String tradeCl;

	@JsonProperty("idCardIssuer")
	private String idCardIssuer;

	@JsonProperty("dateOfEntry")
	@JsonFormat(pattern = DATE_FORMAT_1)
	private LocalDate dateOfEntry;

	@JsonProperty("bloodGroup")
	private String bloodGroup;

	@JsonProperty("employeeSports")
	private List<EmployeeSportModel> employeeSports = new ArrayList<>();

	@JsonProperty("empName")
	private String empName;

	@JsonProperty("id")
	private String id;

	@JsonProperty("employeePunishments")
	private List<EmployeePunishmentModel> employeePunishments = new ArrayList<>();

	@JsonProperty("height")
	private String height;

	@JsonProperty("civQualification")
	private String civQualification;

	@JsonProperty("misc")
	private String misc;

	@JsonProperty("computerKnowledge")
	private String computerKnowledge;

	@JsonProperty("mr")
	private String mr;

	@JsonProperty("employeeCourses")
	private List<EmployeeCourseModel> employeeCourses = new ArrayList<>();

	@JsonProperty("familyFued")
	private String familyFued;

	@JsonProperty("vehicle")
	private String vehicle;

	@JsonProperty("motherName")
	private String motherName;

	@JsonProperty("aadhaarNum")
	private String aadhaarNum;

	@JsonProperty("weight")
	private String weight;

	@JsonProperty("employeeAddresses")
	private List<EmployeeAddressModel> employeeAddresses = new ArrayList<>();

	@JsonProperty("dateOfBirth")
	@JsonFormat(pattern = DATE_FORMAT_1)
	private LocalDate dateOfBirth;

	@JsonProperty("mobileNumNok")
	private String mobileNumNok;

	@JsonProperty("leaveEncashed")
	private String leaveEncashed;

	@JsonProperty("idCardIssueDate")
	@JsonFormat(pattern = DATE_FORMAT_1)
	private LocalDate idCardIssueDate;

	@JsonProperty("mobileNumOwn")
	private String mobileNumOwn;

	@JsonProperty("lifeStyleDisease")
	private String lifeStyleDisease;

	@JsonProperty("empRank")
	private String empRank;

	@JsonProperty("bankAccNum")
	private String bankAccNum;

	@JsonProperty("nokDetails")
	private String nokDetails;

	@JsonProperty("trade")
	private String trade;

	@JsonProperty("civCase")
	private String civCase;

	@JsonProperty("hobbies")
	private String hobbies;

	@JsonProperty("idCardNum")
	private String idCardNum;

	@JsonProperty("employeeFamilies")
	private List<EmployeeFamilyModel> employeeFamilies = new ArrayList<>();

	@JsonProperty("impApptsInService")
	private String impApptsInService;
}