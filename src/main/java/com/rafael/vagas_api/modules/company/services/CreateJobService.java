package com.rafael.vagas_api.modules.company.services;

import com.rafael.vagas_api.modules.company.entities.JobEntity;
import com.rafael.vagas_api.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public ResponseEntity<Object> execute(JobEntity jobEntity) {
        try {
            var result = this.jobRepository.save(jobEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
