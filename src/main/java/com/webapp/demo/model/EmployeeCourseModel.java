package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeCourseModel {

	@JsonProperty("courseName")
	private String courseName;

	@JsonProperty("grading")
	private String grading;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("startDate")
	private String startDate;

	@JsonProperty("remarks")
	private String remarks;
}