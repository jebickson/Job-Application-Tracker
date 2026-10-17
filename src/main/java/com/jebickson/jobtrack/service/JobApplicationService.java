package com.jebickson.jobtrack.service;

import com.jebickson.jobtrack.entity.JobApplication;
import com.jebickson.jobtrack.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplication> getAll() {
        return repository.findAll();
    }

    public JobApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Application not found: " + id));
    }

    public JobApplication create(JobApplication application) {
        application.setId(null);

        if (application.getStatus() == null ||
                application.getStatus().isBlank()) {
            application.setStatus("APPLIED");
        }

        return repository.save(application);
    }

    public JobApplication update(Long id, JobApplication updated) {
        JobApplication existing = getById(id);

        existing.setCompany(updated.getCompany());
        existing.setRole(updated.getRole());
        existing.setStatus(updated.getStatus());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setNotes(updated.getNotes());

        return repository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}