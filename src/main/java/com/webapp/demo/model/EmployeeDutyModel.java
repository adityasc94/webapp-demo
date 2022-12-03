package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeDutyModel {

	@JsonProperty("ereDetail")
	private String ereDetail;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("startDate")
	private String startDate;

	@JsonProperty("remarks")
	private String remarks;
}