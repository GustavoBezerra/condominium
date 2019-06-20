package br.com.condominium.controller;

import br.com.condominium.model.dto.ResidentDTO;
import br.com.condominium.model.entity.Resident;
import br.com.condominium.model.form.ResidentForm;
import br.com.condominium.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.condominium.config.URIConfigs.REPRESENTS_URI;

@RestController
@RequestMapping(REPRESENTS_URI)
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping
    public ResponseEntity<ResidentDTO> create(@RequestBody @Valid ResidentForm request, UriComponentsBuilder uriBuilder){
        Resident resident = residentService.save(request.toResident());
        URI uri = uriBuilder.path(REPRESENTS_URI + "/{id}").buildAndExpand(resident.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResidentDTO(resident));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidentDTO> getById(@PathVariable("id") String id){
        Resident resident = residentService.getById(id);
        return ResponseEntity.ok(new ResidentDTO(resident));
    }

    @GetMapping
    public ResponseEntity<List<ResidentDTO>> getAll(){
        List<Resident> residents = residentService.getAll();
        List<ResidentDTO> residentDTOS = residents.stream().map(ResidentDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(residentDTOS);
    }
}
