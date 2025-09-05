package com.example.employee_api.controller;

import com.example.employee_api.model.Department;
import com.example.employee_api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    // READ - Get all departments
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    // READ - Get department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id){
        try{
            Department department = departmentService.getDepartmentById(id);
            return ResponseEntity.ok(department);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // UPDATE - Update department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id,
                                                       @RequestBody Department updatedDepartment) {
        try {
            Department department = departmentService.updateDepartment(id, updatedDepartment);
            return ResponseEntity.ok(department);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String id) {
        try {
            departmentService.getDepartmentById(id); // Check if exists
            departmentService.deleteDepartment(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
