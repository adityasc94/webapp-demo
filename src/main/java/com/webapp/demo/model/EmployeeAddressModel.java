package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeAddressModel {

	@JsonProperty("village")
	private String village;

	@JsonProperty("post")
	private String post;

	@JsonProperty("tehsil")
	private String tehsil;

	@JsonProperty("district")
	private String district;

	@JsonProperty("state")
	private String state;

	@JsonProperty("pin")
	private String pin;

	@JsonProperty("addressType")
	private String addressType;

}