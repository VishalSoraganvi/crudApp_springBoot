package com.employee.crudApplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

//    Check if you can omit Id parameter in the constructor
    public Employee(Long id , String name, String department) {
        super();
        this.id=id;
        this.name = name;
        this.department = department;
    }

    public Employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
