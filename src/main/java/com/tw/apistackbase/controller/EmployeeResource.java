package com.tw.apistackbase.controller;
import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tw.apistackbase.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    List<Employee> employeeList = new ArrayList<>();

    @GetMapping(path = "/employees", produces = {"application/json"})
    public List<Employee> getAll() {
        return employeeList.stream()
                .map(employee -> employee)
                .collect(Collectors.toList());
    }

    @PostMapping("/add_employee")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return ResponseEntity.ok("Employee added for ID: " + employee.getId());
    }

    @PutMapping("/update_employee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        for(Employee element : employeeList){
            if(element.getId() == employee.getId()){
                element.setName(employee.getName());
                element.setAge(employee.getAge());
                element.setGender(employee.getGender());
            }
        }
        return ResponseEntity.ok("Details updated for Employee ID: " + employee.getId());
    }

    @RequestMapping(value= "/delete_employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable("id") int id) {
        ListIterator<Employee> iter = employeeList.listIterator();
        while(iter.hasNext()){
            if(iter.next().getId() == id){
                iter.remove();
            }
        }
        return ResponseEntity.ok("Data delete for Employee ID: " + id);
    }

    @GetMapping(path = "/search_employee/{id}", produces = {"application/json"})
    public List<Employee> searchEmployee(@PathVariable("id") int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .collect(Collectors.toList());
    }
}


