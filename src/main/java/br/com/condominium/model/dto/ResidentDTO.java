package br.com.condominium.model.dto;

import br.com.condominium.model.entity.Resident;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResidentDTO {

    private String id;
    private String name;
    private String rg;
    private String apartment;
    private LocalDateTime createdAt;

    public ResidentDTO(){}

    public ResidentDTO(Resident resident){
        this.id = resident.getId();
        this.name = resident.getName();
        this.rg = resident.getRg();
        this.apartment = resident.getApartment();
        this.createdAt = resident.getCreatedAt();
    }
}
