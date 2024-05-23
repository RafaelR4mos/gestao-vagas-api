package com.rafael.vagas_api.modules.candidate.services;

import com.rafael.vagas_api.exeptions.UserFoundException;
import com.rafael.vagas_api.modules.candidate.entities.CandidateEntity;
import com.rafael.vagas_api.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        String encryptedPassword = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(encryptedPassword);

        return this.candidateRepository.save(candidateEntity);
    }
}
