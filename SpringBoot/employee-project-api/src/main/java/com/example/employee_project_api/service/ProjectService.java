package com.example.employee_project_api.service;


import com.example.employee_project_api.entity.Employee;
import com.example.employee_project_api.entity.Project;
import com.example.employee_project_api.repository.EmployeeRepository;
import com.example.employee_project_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepo;
    private final EmployeeRepository employeeRepo;

    public ProjectService(ProjectRepository projectRepo, EmployeeRepository employeeRepo) {
        this.projectRepo = projectRepo;
        this.employeeRepo = employeeRepo;
    }

    public Project createProject(Project p) {
        return projectRepo.save(p);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Optional<Project> getProject(Long id) {
        return projectRepo.findById(id);
    }

    public Project updateProject(Long id, Project newProj){
        return projectRepo.findById(id).map(proj -> {
            proj.setPname(newProj.getPname());
            proj.setBudget(newProj.getBudget());
            return projectRepo.save(proj);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }

    public List<Employee> getEmployees(Long pid) {
        Project proj = projectRepo.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return proj.getEmployees().stream().toList();
    }
}
