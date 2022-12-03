package com.webapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestObject {

    @JsonProperty("employee")
    private EmployeeModel employeeModel;

}
