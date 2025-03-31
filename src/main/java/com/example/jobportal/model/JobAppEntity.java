package com.example.jobportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

    @Entity
    @Table(name = "job_applications")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class JobAppEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "job_seeker_id", nullable = false)
        private JobSeeker jobSeeker;

        @ManyToOne
        @JoinColumn(name = "job_posting_id", nullable = false)
        private JobEntity jobPosting;

        @Column(nullable = false)
        private LocalDate applicationDate;

        @Column(nullable = false)
        private String status; // e.g., "Pending", "Accepted", "Rejected"


}
