package com.rafael.vagas_api.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

    private String message;
    private String field;
}
