package com.mapping.Employee.Controller;

import com.mapping.Employee.Entity.Employee;
import com.mapping.Employee.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/v1/emp-management/emp", method = RequestMethod.POST)
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/v1/emp-management/emp/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/v1/emp-management/emp", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/v1/emp-management/emp-bank/{bank-name}", method = RequestMethod.GET)
    public List<Employee> getByBankName(@PathVariable String bankname) {
        return employeeService.findByBankName(bankname);
    }

    @RequestMapping(value = "/v1/emp-management/emp", method = RequestMethod.PUT)
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}

