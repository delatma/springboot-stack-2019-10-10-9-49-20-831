package com.tw.apistackbase.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tw.apistackbase.model.Employee;

import java.util.logging.Logger;

public class EmployeeController {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    @RestController
    public class WebController {
        @RequestMapping("/employees")
        public Employee Sample(@RequestParam(value = "name",
                defaultValue = "Robot") String name) {
            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("Your name is "+name);
            return employee;
        }
    }

}
