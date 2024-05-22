package com.rafael.vagas_api.modules.company.repositories;

import com.rafael.vagas_api.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
