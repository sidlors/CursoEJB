package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Past;

@Entity
public class Employee implements Serializable {

    @Id
    @Column
    private int id;
    private String firstName;
    private String lastName;
    @Past(message = "The birth Date must be in the past!")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private float salary;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Date birthDate, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}