package br.com.condominium.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "residents")
public class Resident {

    @Id
    @Column(nullable = false, length = 50)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(unique=true)
    private String rg;

    @Column(nullable = false)
    private String apartment;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Resident() {
    }

    public Resident(String name, String rg, String apartment) {
        this.name = name;
        this.rg = rg;
        this.apartment = apartment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
