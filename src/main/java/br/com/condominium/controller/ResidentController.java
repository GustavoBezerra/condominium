package br.com.condominium.controller;

import br.com.condominium.model.dto.ResidentDTO;
import br.com.condominium.model.entity.Resident;
import br.com.condominium.model.form.ResidentForm;
import br.com.condominium.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static br.com.condominium.config.URIConfigs.REPRESENTS_URI;

@RestController(REPRESENTS_URI)
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping
    public ResponseEntity<ResidentDTO> create(@RequestBody @Valid ResidentForm request, UriComponentsBuilder uriBuilder){
        Resident resident = residentService.save(request.toResident());
        URI uri = uriBuilder.path(REPRESENTS_URI + "/{id}").buildAndExpand(resident.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResidentDTO(resident));
    }
}
