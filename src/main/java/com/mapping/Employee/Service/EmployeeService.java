package com.mapping.Employee.Service;


import com.mapping.Employee.Entity.Employee;
import com.mapping.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "New Employee Created ID : " + employee.getId();
    }

    public Optional<Employee> getEmployee(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByBankName(String bankname) {
        return employeeRepository.findEmployeeByBankBankName(bankname);
    }

}
