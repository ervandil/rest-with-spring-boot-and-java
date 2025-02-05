package br.com.ervandil.mapper;

import br.com.ervandil.model.Person;
import br.com.ervandil.vo.v1.PersonVO;
import br.com.ervandil.vo.v2.PersonVOV2;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO toVO(Person person);

    PersonVOV2 toVOV2(Person person);

    Person toEntity(PersonVO personVO);

    Person toEntity(PersonVOV2 personVOV2);

    List<PersonVO> toVOList(List<Person> users);

    List<Person> toEntityList(List<PersonVO> users);
}