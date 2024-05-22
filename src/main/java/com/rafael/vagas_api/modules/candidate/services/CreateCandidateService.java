package com.rafael.vagas_api.modules.candidate.services;

import com.rafael.vagas_api.exeptions.UserFoundException;
import com.rafael.vagas_api.modules.candidate.CandidateEntity;
import com.rafael.vagas_api.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
