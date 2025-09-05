package com.example.employee_project_api.controller;

import com.example.employee_project_api.entity.Employee;
import com.example.employee_project_api.entity.Project;
import com.example.employee_project_api.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return service.createEmployee(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployee(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        return service.updateEmployee(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

    @PostMapping("/{eid}/projects/{pid}")
    public Employee assignProject(@PathVariable Long eid, @PathVariable Long pid) {
        return service.assignProject(eid, pid);
    }

    @GetMapping("/{eid}/projects")
    public List<Project> getProjects(@PathVariable Long eid) {
        return service.getProjects(eid);
    }


}
