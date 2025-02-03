package br.com.ervandil.mapper;

import br.com.ervandil.model.Person;
import br.com.ervandil.vo.v1.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO toVO(Person person);

    Person toEntity(PersonVO personVO);

    List<PersonVO> toVOList(List<Person> users);

    List<Person> toEntityList(List<PersonVO> users);
}