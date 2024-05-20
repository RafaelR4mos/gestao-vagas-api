package com.rafael.vagas_api.modules.candidate.controllers;

import com.rafael.vagas_api.modules.candidate.CandidateEntity;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public ResponseEntity<CandidateEntity> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        return ResponseEntity.ok().body(candidateEntity);
    }
}
