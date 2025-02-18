package br.com.erudio.services;

import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.exception.RequiredObjectIsNullException;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;


    public List<PersonDTOV2> findAllV2() {
        logger.info("Finding all People V2!");
        var persons = PersonMapper.INSTANCE.toDTOV2List(repository.findAll());
        persons.forEach(this::addHateoasLinksV2);
        return persons;
    }

    public List<PersonDTOV3> findAllV3() {
        logger.info("Finding all People V3!");
        var persons = PersonMapper.INSTANCE.toDTOV3List(repository.findAll());
        persons.forEach(this::addHateoasLinksV3);
        return persons;
    }

    public PersonDTOV3 findByIdV3(Long id) {
        logger.info("Finding one Person V3!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = PersonMapper.INSTANCE.toDTOV3(entity);
        addHateoasLinksV3(dto);
        return dto;
    }


    public PersonDTOV2 findByIdV2(Long id) {
        logger.info("Finding one Person V2!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = PersonMapper.INSTANCE.toDTOV2(entity);
        addHateoasLinksV2(dto);
        return dto;
    }

    public PersonDTOV3 createV3(PersonDTOV3 person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one Person V3!");
        var entity = PersonMapper.INSTANCE.toEntityV3(person);
        var dto = PersonMapper.INSTANCE.toDTOV3(repository.save(entity));
        addHateoasLinksV3(dto);
        return dto;
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one Person V2!");
        var entity = PersonMapper.INSTANCE.toEntityV2(person);
        var dto = PersonMapper.INSTANCE.toDTOV2(repository.save(entity));
        addHateoasLinksV2(dto);
        return dto;
    }

    public PersonDTOV3 updateV3(PersonDTOV3 person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one Person V3!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setPhoneNumber(person.getPhoneNumber());
        var dto = PersonMapper.INSTANCE.toDTOV3(repository.save(entity));
        addHateoasLinksV3(dto);
        return dto;
    }

    public PersonDTOV2 updateV2(PersonDTOV2 person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one Person V2!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setBirthDay(person.getBirthDay());
        var dto = PersonMapper.INSTANCE.toDTOV2(repository.save(entity));
        addHateoasLinksV2(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private void addHateoasLinksV3(PersonDTOV3 entity) {
        entity.add(linkTo(methodOn(PersonController.class).findByIdV3(entity.getId())).withSelfRel().withType("GET"));
        entity.add(linkTo(methodOn(PersonController.class).delete(entity.getId())).withRel("delete").withType("DELETE"));
        entity.add(linkTo(methodOn(PersonController.class).findAllV3()).withRel("findAllV3").withType("GET"));
        entity.add(linkTo(methodOn(PersonController.class).create(entity)).withRel("create").withType("POST"));
        entity.add(linkTo(methodOn(PersonController.class).create(entity)).withRel("update").withType("PUT"));
    }

    private void addHateoasLinksV2(PersonDTOV2 entity) {
        entity.add(linkTo(methodOn(PersonController.class).findByIdV2(entity.getId())).withSelfRel().withType("GET"));
        entity.add(linkTo(methodOn(PersonController.class).delete(entity.getId())).withRel("delete").withType("DELETE"));
        entity.add(linkTo(methodOn(PersonController.class).findAllV2()).withRel("findAllV2").withType("GET"));
        entity.add(linkTo(methodOn(PersonController.class).create(entity)).withRel("create").withType("POST"));
        entity.add(linkTo(methodOn(PersonController.class).create(entity)).withRel("update").withType("PUT"));
    }
}

