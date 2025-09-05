package com.example.employee_api.service;

import com.example.employee_api.model.Department;
import com.example.employee_api.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    //CREATE
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    //READ
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String id){
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    public Optional<Department> findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(String id, Department newData) {
        Department department = getDepartmentById(id);
        department.setDname(newData.getDname());
        return departmentRepository.save(department);
    }

    // DELETE
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
