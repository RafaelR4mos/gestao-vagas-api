package com.rafael.vagas_api.modules.company.services;

import com.rafael.vagas_api.exeptions.UserFoundException;
import com.rafael.vagas_api.modules.company.entities.CompanyEntity;
import com.rafael.vagas_api.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var encryptedPassword = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(encryptedPassword);

        return this.companyRepository.save(companyEntity);
    }

}
