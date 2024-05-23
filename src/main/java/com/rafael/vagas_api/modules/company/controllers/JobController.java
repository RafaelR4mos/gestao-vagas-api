package com.rafael.vagas_api.modules.company.controllers;

import com.rafael.vagas_api.modules.company.dto.CreateJobDTO;
import com.rafael.vagas_api.modules.company.entities.JobEntity;
import com.rafael.vagas_api.modules.company.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        Object companyId = request.getAttribute("company_id");

       JobEntity jobEntity = JobEntity.builder()
               .benefits(createJobDTO.getBenefits())
               .companyId(UUID.fromString(companyId.toString()))
               .description(createJobDTO.getDescription())
               .level(createJobDTO.getLevel())
               .build();

        return this.createJobService.execute(jobEntity);
    }
}
