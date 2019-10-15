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

    @PutMapping("/update_employee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        for(Employee element : employeeList){
            if(element.getId() == employee.getId()){
                element.setName(employee.getName());
                element.setAge(employee.getAge());
                element.setGender(employee.getGender());
            }
            if(element.getId() != employee.getId()){
                return ResponseEntity.ok("ID does not exist!\n");
            }
        }
        return ResponseEntity.ok("Details updated for Employee ID: " + employee.getId() + "\n" +
                employee);
    }

    //    public ResponseEntity createEmployee(@RequestBody Employee employee) {
//        employeeList.add(employee);
//        return ResponseEntity.ok(employee);
//    }

}
