package com.rafael.vagas_api.modules.candidate.controllers;

import com.rafael.vagas_api.modules.candidate.dto.AuthCandidateRequestDTO;
import com.rafael.vagas_api.modules.candidate.services.AuthCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateService authCandidateService;

    @PostMapping("/candidate")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {
        try {
            var token = this.authCandidateService.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(token);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
