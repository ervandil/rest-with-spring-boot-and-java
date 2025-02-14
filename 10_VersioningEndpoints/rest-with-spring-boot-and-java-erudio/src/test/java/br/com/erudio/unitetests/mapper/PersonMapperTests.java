package br.com.erudio.unitetests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.mapper.PersonMapper;
import br.com.erudio.unitetests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.erudio.model.Person;

public class PersonMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOTest() {
        PersonDTOV1 output = PersonMapper.INSTANCE.toDTO(inputObject.mockEntity());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityToDTOV2Test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        PersonDTOV2 output = PersonMapper.INSTANCE.toDTOV2(inputObject.mockEntity());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals(date, output.getBirthDay());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDTOV1> outputList = PersonMapper.INSTANCE.toDTOList(inputObject.mockEntityList());
        PersonDTOV1 outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        PersonDTOV1 outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        PersonDTOV1 outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseEntityListV2ToDTOListTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        List<PersonDTOV2> outputList = PersonMapper.INSTANCE.toDTOV2List(inputObject.mockEntityList());
        PersonDTOV2 outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals(date, outputZero.getBirthDay());

        PersonDTOV2 outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals(date, outputSeven.getBirthDay());

        PersonDTOV2 outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals(date, outputTwelve.getBirthDay());
    }


    @Test
    public void parseDTOToEntityTest() {
        Person output = PersonMapper.INSTANCE.toEntity(inputObject.mockDTO());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseDTOV2ToEntityTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        Person output = PersonMapper.INSTANCE.toEntityV2(inputObject.mockDTOV2());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals(date, output.getBirthDay());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = PersonMapper.INSTANCE.toEntityList(inputObject.mockDTOList());
        Person outputZero = outputList.getFirst();
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parserDTOV2ListToEntityListTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();

        List<Person> outputList = PersonMapper.INSTANCE.toEntityV2List(inputObject.mockDTOV2List());
        Person outputZero = outputList.getFirst();
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals(date, outputZero.getBirthDay());

        Person outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals(date, outputSeven.getBirthDay());

        Person outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals(date, outputTwelve.getBirthDay());
    }
}
