package br.com.erudio.mapper;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTOV2 toDTOV2(Person person);

    PersonDTOV3 toDTOV3(Person person);

    @Mapping(target = "phoneNumber", ignore = true)
    Person toEntityV2(PersonDTOV2 personDTO);

    Person toEntityV3(PersonDTOV3 personDTO);

    List<PersonDTOV2> toDTOV2List(List<Person> users);

    List<PersonDTOV3> toDTOV3List(List<Person> users);

    @Mapping(target = "phoneNumber", ignore = true)
    List<Person> toEntityV2List(List<PersonDTOV2> users);

    List<Person> toEntityV3List(List<PersonDTOV3> users);

}
