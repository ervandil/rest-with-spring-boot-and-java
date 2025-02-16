package br.com.erudio.mapper;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTOV1 toDTO(Person person);

    PersonDTOV2 toDTOV2(Person person);

    @Mapping(target = "birthDay", ignore = true)
    Person toEntity(PersonDTOV1 personDTO);

    Person toEntityV2(PersonDTOV2 personDTO);

    List<PersonDTOV1> toDTOList(List<Person> users);

    List<PersonDTOV2> toDTOV2List(List<Person> users);

    @Mapping(target = "birthDay", ignore = true)
    List<Person> toEntityList(List<PersonDTOV1> users);

    List<Person> toEntityV2List(List<PersonDTOV2> users);
}
