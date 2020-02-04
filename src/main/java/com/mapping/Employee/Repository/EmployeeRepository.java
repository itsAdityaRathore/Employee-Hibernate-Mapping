package com.mapping.Employee.Repository;


import com.mapping.Employee.Entity.Employee;
import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByBankBankName(String bankname);
}
