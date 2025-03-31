package com.example.jobportal.repository;

import com.example.jobportal.model.JobEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface job_repo extends JpaRepository<JobEntity, Long> {

    // Custom JPQL Query to find jobs by title
    @Query("SELECT j FROM JobEntity j WHERE j.title LIKE %:title% AND j.location LIKE %:location%")
    List<JobEntity> findBySpecs (String title , String location);

    @Query("SELECT j FROM JobEntity j WHERE j.company LIKE %:company%")
    List<JobEntity> findByCompany(String company);
    // Sorting and Pagination
    Page<JobEntity> findAll(Pageable pageable);

//    List<JobEntity>deleteByLocation(String location);
    List<JobEntity> findByLocation(String location);
}
