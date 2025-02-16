package br.com.erudio.controllers;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person/api")
public class PersonController {

    @Autowired
    private PersonServices service;
    // private PersonServices service = new PersonServices();

    @GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV1> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTOV2> findAllV2() {
        return service.findAllV2();
    }

    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/v2/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 findByIdV2(@PathVariable("id") Long id) {
        return service.findByIdV2(id);
    }

    @PostMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 create(@RequestBody PersonDTOV1 person) {
        return service.create(person);
    }

    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
        return service.createV2(person);
    }

    @PutMapping(value = "/v1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV1 update(@RequestBody PersonDTOV1 person) {
        return service.update(person);
    }

    @PutMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 update(@RequestBody PersonDTOV2 person) {
        return service.updateV2(person);
    }

    @DeleteMapping(value = "/v2/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
