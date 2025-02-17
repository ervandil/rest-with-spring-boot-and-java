package br.com.erudio.services;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.mapper.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;


    public List<PersonDTOV2> findAllV2() {
        logger.info("Finding all People V2!");
        return PersonMapper.INSTANCE.toDTOV2List(repository.findAll());
    }

    public List<PersonDTOV3> findAllV3() {
        logger.info("Finding all People V3!");
        return PersonMapper.INSTANCE.toDTOV3List(repository.findAll());
    }

    public PersonDTOV3 findByIdV3(Long id) {
        logger.info("Finding one Person V3!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return PersonMapper.INSTANCE.toDTOV3(entity);
    }

    public PersonDTOV2 findByIdV2(Long id) {
        logger.info("Finding one Person V2!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return PersonMapper.INSTANCE.toDTOV2(entity);
    }

    public PersonDTOV3 createV3(PersonDTOV3 person) {
        logger.info("Creating one Person V3!");
        var entity = PersonMapper.INSTANCE.toEntityV3(person);
        return PersonMapper.INSTANCE.toDTOV3(repository.save(entity));
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one Person V2!");
        var entity = PersonMapper.INSTANCE.toEntityV2(person);
        return PersonMapper.INSTANCE.toDTOV2(repository.save(entity));
    }

    public PersonDTOV3 updateV3(PersonDTOV3 person) {
        logger.info("Updating one Person V3!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setPhoneNumber(person.getPhoneNumber());
        return PersonMapper.INSTANCE.toDTOV3(repository.save(entity));
    }

    public PersonDTOV2 updateV2(PersonDTOV2 person) {
        logger.info("Updating one Person V2!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setBirthDay(person.getBirthDay());
        return PersonMapper.INSTANCE.toDTOV2(repository.save(entity));
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}