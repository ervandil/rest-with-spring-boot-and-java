package br.com.erudio.mapper;

import br.com.erudio.dto.PersonDTO;
import br.com.erudio.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDTO(Person person);

    Person toEntity(PersonDTO personDTO);

    List<PersonDTO> toDTOList(List<Person> users);

    List<Person> toEntityList(List<PersonDTO> users);
}
