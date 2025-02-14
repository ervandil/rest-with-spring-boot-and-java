package br.com.erudio.services;

import br.com.erudio.dto.PersonDTO;
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


    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return PersonMapper.INSTANCE.toDTOList(repository.findAll());
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return PersonMapper.INSTANCE.toDTO(entity);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");
        var entity = PersonMapper.INSTANCE.toEntity(person);
        return PersonMapper.INSTANCE.toDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return PersonMapper.INSTANCE.toDTO(repository.save(entity));
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}