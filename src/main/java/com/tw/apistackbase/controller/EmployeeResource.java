package com.tw.apistackbase.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tw.apistackbase.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    List<Employee> employeeList = new ArrayList<>();

    @GetMapping(path = "/employees", produces = {"application/json"})
    public List<Employee> getAll() {
        return employeeList;
    }

    @PostMapping("/add_employee")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return ResponseEntity.ok(employee);
    }

    //    public ResponseEntity createEmployee(@RequestBody Employee employee) {
//        employeeList.add(employee);
//        return ResponseEntity.ok(employee);
//    }

}
