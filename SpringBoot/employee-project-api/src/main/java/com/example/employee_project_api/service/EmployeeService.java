package com.example.employee_project_api.service;

import com.example.employee_project_api.entity.Employee;
import com.example.employee_project_api.entity.Project;
import com.example.employee_project_api.repository.EmployeeRepository;
import com.example.employee_project_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final ProjectRepository projectRepo;

    //CREATE
    public EmployeeService(EmployeeRepository employeeRepo, ProjectRepository projectRepo) {
        this.employeeRepo = employeeRepo;
        this.projectRepo = projectRepo;
    }

    //READ
    public Employee createEmployee(Employee e){
        return employeeRepo.save(e);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployee(Long id) {
        return employeeRepo.findById(id);
    }

    //UPDATE
    public Employee updateEmployee(Long id, Employee newEmp) {
        return employeeRepo.findById(id).map(emp -> {
            emp.setFirstName(newEmp.getFirstName());
            emp.setSalary(newEmp.getSalary());
            return employeeRepo.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee assignProject(Long eid, Long pid){
        Employee emp = employeeRepo.findById(eid)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Project proj = projectRepo.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        emp.getProjects().add(proj);
        return employeeRepo.save(emp);
    }

    public List<Project> getProjects(Long eid) {
        Employee emp = employeeRepo.findById(eid)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return emp.getProjects().stream().toList();
    }
}
