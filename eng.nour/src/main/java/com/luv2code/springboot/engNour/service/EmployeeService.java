package com.luv2code.springboot.engNour.service;


import com.luv2code.springboot.engNour.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    List<Employee> findAll();

    Optional<Employee> findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);

}
