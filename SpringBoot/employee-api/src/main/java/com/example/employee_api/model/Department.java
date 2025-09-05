package com.example.employee_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "did", length = 10)
    private String did;

    @Column(name = "dname", nullable = false, length = 100)
    private String dname;

    // CONSTRUCTOR IMPLICIT - OBLIGATORIU pentru JPA
    public Department() {
    }

    // Constructor cu parametri
    public Department(String did, String dname) {
        this.did = did;
        this.dname = dname;
    }


    @Override
    public String toString() {
        return "Department{" +
                "did='" + did + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}