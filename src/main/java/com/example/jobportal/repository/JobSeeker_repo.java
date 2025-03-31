package com.example.jobportal.repository;

import com.example.jobportal.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeeker_repo extends JpaRepository<JobSeeker, Long> {
    Optional<JobSeeker> findByEmail(String email);
}

