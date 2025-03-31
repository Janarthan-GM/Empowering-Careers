package com.example.jobportal.repository;

import com.example.jobportal.model.JobAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApp_repo extends JpaRepository<JobAppEntity, Long> {

    List<JobAppEntity> findByCompanyName(String companyName);
}
