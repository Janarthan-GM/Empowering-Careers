package com.example.jobportal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_entity") // Correct table name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    @Column(length = 500)
    private String description;
    public void setSalary(double salary) {
        this.salary = salary;
    }
    private double salary;

    public double getSalary() {
        return salary;
    }
}
