package com.luv2code.springboot.engNour.controller;

import com.luv2code.springboot.engNour.entity.Employee;
import com.luv2code.springboot.engNour.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model themodel){
        Employee theEmployee = new Employee();

        themodel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId , Model themodel){
        Optional<Employee> theEmployee=employeeService.findById(theId);
        themodel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee (@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete (@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);

        return "redirect:/employees/list";
    }
}












