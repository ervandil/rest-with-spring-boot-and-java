package br.com.erudio.services;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
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


    public List<PersonDTOV1> findAll() {
        logger.info("Finding all People!");
        return PersonMapper.INSTANCE.toDTOList(repository.findAll());
    }

    public List<PersonDTOV2> findAllV2() {
        logger.info("Finding all People V2!");
        return PersonMapper.INSTANCE.toDTOV2List(repository.findAll());
    }

    public PersonDTOV1 findById(Long id) {
        logger.info("Finding one Person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return PersonMapper.INSTANCE.toDTO(entity);
    }

    public PersonDTOV2 findByIdV2(Long id) {
        logger.info("Finding one Person V2!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return PersonMapper.INSTANCE.toDTOV2(entity);
    }

    public PersonDTOV1 create(PersonDTOV1 person) {
        logger.info("Creating one Person!");
        var entity = PersonMapper.INSTANCE.toEntity(person);
        return PersonMapper.INSTANCE.toDTO(repository.save(entity));
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one Person V2!");
        var entity = PersonMapper.INSTANCE.toEntityV2(person);
        return PersonMapper.INSTANCE.toDTOV2(repository.save(entity));
    }

    public PersonDTOV1 update(PersonDTOV1 person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return PersonMapper.INSTANCE.toDTO(repository.save(entity));
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