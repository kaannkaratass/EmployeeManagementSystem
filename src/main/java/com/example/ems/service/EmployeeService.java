package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Boyle bir id yok"));
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee employee1 = getEmployeeById(id);
        employee1.setName(employee.getName());
        employee1.setSurname(employee.getSurname());
        employee1.setEmail(employee.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee1);
        return updatedEmployee ;
    }

    public Map<String,Boolean> deleteEmployee(Long id) {
        Employee findById = getEmployeeById(id);
        employeeRepository.delete(findById);
        Map<String,Boolean> deletedItem = new HashMap<>();
        deletedItem.put("DELETED",true);
        return deletedItem;
    }
}
