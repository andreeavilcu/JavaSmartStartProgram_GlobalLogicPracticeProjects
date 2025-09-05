package com.example.employee_api.service;
import com.example.employee_api.model.Employee;
import com.example.employee_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee newData) {
        Employee employee = getEmployeeById(id);
        employee.setFirstName(newData.getFirstName());
        employee.setSalary(newData.getSalary());
        employee.setAddress(newData.getAddress());
        employee.setDepartment(newData.getDepartment());
        return employeeRepository.save(employee);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // EXTRA BUSINESS LOGIC: Salary increase
    public Employee increaseSalary(Long id, double percent) {
        Employee employee = getEmployeeById(id);
        double currentSalary = employee.getSalary() != null ? employee.getSalary() : 0.0;
        employee.setSalary(currentSalary * (1 + percent / 100));
        return employeeRepository.save(employee);
    }

    // Legacy method for compatibility
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
