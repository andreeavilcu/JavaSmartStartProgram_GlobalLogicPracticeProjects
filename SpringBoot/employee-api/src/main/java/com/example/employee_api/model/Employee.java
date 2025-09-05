package com.example.employee_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="eid")
    private Long eId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "address", length = 200)
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){

    }

    public Employee(String firstName, Double salary, String address, Department department) {
        this.firstName = firstName;
        this.salary = salary;
        this.address = address;
        this.department = department;
    }


    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", department=" + department +
                '}';
    }
}
