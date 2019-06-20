package br.com.condominium.service;

import br.com.condominium.model.entity.Resident;
import br.com.condominium.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    public Resident save(Resident resident) {
        resident.setId(UUID.randomUUID().toString());
        resident.setCreatedAt(LocalDateTime.now());

        return residentRepository.save(resident);
    }
}
