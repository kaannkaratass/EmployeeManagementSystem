package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @PostMapping("/employees")
    public Employee insertEmployee(@RequestBody Employee employee){
        List<Employee> employeeList = getEmployeeList();
        for (Employee employees : employeeList){
            String emails = employees.getEmail();
            if (employee.getEmail().equals(emails)){
                return new Employee();
            }
        }

        return employeeService.insertEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee employee){
        return employeeService.updateEmployee(id , employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
