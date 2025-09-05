package com.example.employee_project_api.controller;

import com.example.employee_project_api.entity.Employee;
import com.example.employee_project_api.entity.Project;
import com.example.employee_project_api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public Project create(@RequestBody Project p) {
        return service.createProject(p);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return service.getProject(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project p) {
        return service.updateProject(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProject(id);
    }

    @GetMapping("/{pid}/employees")
    public List<Employee> getEmployees(@PathVariable Long pid) {
        return service.getEmployees(pid);
    }
}
