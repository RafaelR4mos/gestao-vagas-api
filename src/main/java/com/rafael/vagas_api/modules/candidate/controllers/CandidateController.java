package com.rafael.vagas_api.modules.candidate.controllers;

import com.rafael.vagas_api.exeptions.UserFoundException;
import com.rafael.vagas_api.modules.candidate.CandidateEntity;

import com.rafael.vagas_api.modules.candidate.CandidateRepository;
import com.rafael.vagas_api.modules.candidate.services.CreateCandidateService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

   @Autowired
   private CreateCandidateService createCandidateService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
