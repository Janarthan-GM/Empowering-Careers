package com.example.jobportal.repository;

import com.example.jobportal.model.AdminEntity;

import com.example.jobportal.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_repo extends JpaRepository<AdminEntity, Long> {
}
