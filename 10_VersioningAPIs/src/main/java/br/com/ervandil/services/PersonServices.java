package br.com.ervandil.services;

import br.com.ervandil.exceptions.ResourceNotFoundException;
import br.com.ervandil.mapper.PersonMapper;
import br.com.ervandil.model.Person;
import br.com.ervandil.repositories.PersonRepository;
import br.com.ervandil.vo.v1.PersonVO;
import br.com.ervandil.vo.v2.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");
        return PersonMapper.INSTANCE.toVOList(repository.findAll());
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return PersonMapper.INSTANCE.toVO(entity);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = PersonMapper.INSTANCE.toEntity(person);
        var vo = PersonMapper.INSTANCE.toVO(repository.save(entity));
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person V2!");
        var entity = PersonMapper.INSTANCE.toEntity(person);
        var vo = PersonMapper.INSTANCE.toVOV2(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = PersonMapper.INSTANCE.toVO(repository.save(entity));
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
