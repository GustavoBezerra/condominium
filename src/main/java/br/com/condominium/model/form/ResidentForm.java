package br.com.condominium.model.form;

import br.com.condominium.model.entity.Resident;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ResidentForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String name;
    @NotNull @NotEmpty
    private String rg;
    @NotNull @NotEmpty
    private String apartment;

    @Override
    public String toString(){
        return new StringBuilder().append("[Name = ")
                .append(name)
                .append(", RG = ")
                .append(rg)
                .append(", AP = ")
                .append(apartment)
                .append("]").toString();
    }

    public Resident toResident(){
        return Resident.builder()
                .name(this.name)
                .rg(this.rg)
                .apartment(this.apartment).build();
    }
}
