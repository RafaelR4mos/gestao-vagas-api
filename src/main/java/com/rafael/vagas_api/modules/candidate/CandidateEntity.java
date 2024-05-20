package com.rafael.vagas_api.modules.candidate;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import jakarta.validation.constraints.Email;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    @Pattern(regexp = "^[^\\s]*$", message = "O campo [username] não deve conter espaços")
    private String username;
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Email(message = "O campo [confirmEmail] deve conter um e-mail válido")
    private String confirmEmail;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;
}
