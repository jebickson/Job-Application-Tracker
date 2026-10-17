package com.jebickson.jobtrack.controller;

import com.jebickson.jobtrack.entity.JobApplication;
import com.jebickson.jobtrack.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public JobApplication getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JobApplication create(
            @RequestBody JobApplication application) {
        return service.create(application);
    }

    @PutMapping("/{id}")
    public JobApplication update(
            @PathVariable Long id,
            @RequestBody JobApplication application) {
        return service.update(id, application);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Application deleted successfully";
    }
}