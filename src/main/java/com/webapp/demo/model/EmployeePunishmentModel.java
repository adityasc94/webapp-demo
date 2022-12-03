package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeePunishmentModel {

	@JsonProperty("punishmentAwarded")
	private String punishmentAwarded;

	@JsonProperty("offence")
	private String offence;

	@JsonProperty("remarks")
	private String remarks;
}