package com.webapp.demo.controller;

import com.webapp.demo.model.RequestObject;
import com.webapp.demo.model.ResponseObject;
import com.webapp.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> addEmployee(@RequestBody RequestObject request) {
        log.info("Received addEmployee request : {}", request);
        ResponseObject response = employeeService.addEmployee(request);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody RequestObject request) {
        log.info("Received updateEmployee request : {}", request);
        ResponseObject response = employeeService.updateEmployee(request);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getAllEmployees() {
        ResponseObject response = employeeService.getAllEmployees();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getEmployee(@RequestParam String empId) {
        log.info("Received getEmployee request for empId : {}", empId);
        ResponseObject response = employeeService.getEmployee(empId);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> deleteEmployee(@RequestParam String empId) {
        log.info("Received deleteEmployee request for empId : {}", empId);
        ResponseObject response = employeeService.deleteEmployee(empId);
        return ResponseEntity.ok(response);
    }

}
