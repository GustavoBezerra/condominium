package br.com.condominium.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorValidationDTO {

    private String field;
    private String error;
}
