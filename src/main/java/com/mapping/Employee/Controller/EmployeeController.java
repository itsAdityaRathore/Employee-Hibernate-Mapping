package com.mapping.Employee.Controller;


import com.mapping.Employee.Entity.Employee;
import com.mapping.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/create-new", method = RequestMethod.POST)
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "get-emp/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "get-emp/find-all", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "get-emp/find-by-bankname/{bankname}", method = RequestMethod.GET)
    public List<Employee> getByBankName(@PathVariable String bankname) {
        return employeeService.findByBankName(bankname);
    }
}

