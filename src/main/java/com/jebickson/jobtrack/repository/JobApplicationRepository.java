package com.jebickson.jobtrack.repository;

import com.jebickson.jobtrack.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {
}