package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeSportModel {

	@JsonProperty("sportPlayed")
	private String sportPlayed;

	@JsonProperty("sportLevel")
	private String sportLevel;

	@JsonProperty("remarks")
	private String remarks;
}