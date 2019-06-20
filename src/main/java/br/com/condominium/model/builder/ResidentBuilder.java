package br.com.condominium.model.builder;

import br.com.condominium.model.entity.Resident;

public class ResidentBuilder {

    private String name;
    private String rg;
    private String apartment;

    public ResidentBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ResidentBuilder withRg(String rg){
        this.rg = rg;
        return this;
    }

    public ResidentBuilder withApartment(String apartment){
        this.apartment = apartment;
        return this;
    }

    public Resident build(){
        return new Resident(this.name, this.rg, this.apartment);
    }
}
