package com.example.employee_api.repository;

import com.example.employee_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    // JpaRepository provides methods like findAll(), findById(), save(),
    //deleteById()
}
