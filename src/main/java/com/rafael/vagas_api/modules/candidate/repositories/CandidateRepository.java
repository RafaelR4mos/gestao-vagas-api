package com.rafael.vagas_api.modules.candidate.repositories;

import com.rafael.vagas_api.modules.candidate.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    public Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
    public Optional<CandidateEntity> findByUsername(String username);
}
