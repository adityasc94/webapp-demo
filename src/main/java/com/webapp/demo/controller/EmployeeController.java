package com.webapp.demo.controller;

import com.webapp.demo.model.EmployeeModel;
import com.webapp.demo.model.RequestObject;
import com.webapp.demo.model.ResponseObject;
import com.webapp.demo.service.EmployeeService;
import com.webapp.demo.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> addEmployee(@RequestBody RequestObject request) {
        log.info("Received addEmployee request : {}", request);
        ResponseObject response = null;
        try {
            if (ObjectUtils.isEmpty(request.getEmployeeModel().getId())) {
                throw new IllegalArgumentException("Employee number cannot be null or empty!");
            }
            employeeService.addEmployee(request);
            response = createSuccessResObj();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Unable to process addEmployee.", e);
            response = createErrorResObj(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody RequestObject request) {
        log.info("Received updateEmployee request : {}", request);
        ResponseObject response = null;
        try {
            employeeService.updateEmployee(request);
            response = createSuccessResObj();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Unable to process updateEmployee.", e);
            response = createErrorResObj(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getAllEmployees() {
        ResponseObject response = null;
        try {
            List<EmployeeModel> employeeModels = employeeService.getAllEmployees();
            response = createSuccessResObj();
            response.setEmployeeModelList(employeeModels);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Unable to process getAllEmployees.", e);
            response = createErrorResObj(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getEmployee(@RequestParam String empId) {
        log.info("Received getEmployee request for empId : {}", empId);
        ResponseObject response = null;
        try {
            List<EmployeeModel> employeeModels = new ArrayList<>();
            EmployeeModel employeeModel = employeeService.getEmployee(empId);
            employeeModels.add(employeeModel);
            response = createSuccessResObj();
            response.setEmployeeModelList(employeeModels);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Unable to process getEmployee.", e);
            response = createErrorResObj(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> deleteEmployee(@RequestParam String empId) {
        log.info("Received deleteEmployee request for empId : {}", empId);
        ResponseObject response = null;
        try {
            employeeService.deleteEmployee(empId);
            response = createSuccessResObj();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Unable to process deleteEmployee.", e);
            response = createErrorResObj(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    private ResponseObject createSuccessResObj() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus(Constants.SUCCESS_STATUS);
        return responseObject;
    }

    private ResponseObject createErrorResObj(String message) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus(Constants.ERROR_STATUS);
        responseObject.setMessage(message);
        return responseObject;
    }

}
