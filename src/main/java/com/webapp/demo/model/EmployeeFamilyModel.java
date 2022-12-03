package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeFamilyModel {

	@JsonProperty("qualification")
	private String qualification;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("memberName")
	private String memberName;

	@JsonProperty("age")
	private String age;
}