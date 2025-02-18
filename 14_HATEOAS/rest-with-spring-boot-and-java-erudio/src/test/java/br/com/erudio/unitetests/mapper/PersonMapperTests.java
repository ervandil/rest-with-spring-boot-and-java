package br.com.erudio.unitetests.mapper;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.mapper.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.unitetests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonMapperTests {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToDTOV3Test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        PersonDTOV3 output = PersonMapper.INSTANCE.toDTOV3(inputObject.mockEntity());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals("51999447744", output.getPhoneNumber());
        assertEquals(date, output.getBirthDay());
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
    public void parseEntityListV3ToDTOListTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        List<PersonDTOV3> outputList = PersonMapper.INSTANCE.toDTOV3List(inputObject.mockEntityList());
        PersonDTOV3 outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals(date, outputZero.getBirthDay());
        assertEquals("51999447744", outputZero.getPhoneNumber());

        PersonDTOV3 outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals(date, outputSeven.getBirthDay());
        assertEquals("51999447744", outputSeven.getPhoneNumber());

        PersonDTOV3 outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals(date, outputTwelve.getBirthDay());
        assertEquals("51999447744", outputTwelve.getPhoneNumber());

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
    public void parseDTOV3ToEntityTest() {
        Person output = PersonMapper.INSTANCE.toEntityV3(inputObject.mockDTOV3());
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals("51999447744", output.getPhoneNumber());
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
    public void parseDTOV3ListToEntityListTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        List<Person> outputList = PersonMapper.INSTANCE.toEntityV3List(inputObject.mockDTOV3List());

        Person outputZero = outputList.getFirst();
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        assertEquals("51999447744", outputZero.getPhoneNumber());
        assertEquals(date, outputZero.getBirthDay());

        Person outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        assertEquals("51999447744", outputSeven.getPhoneNumber());
        assertEquals(date, outputSeven.getBirthDay());

        Person outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
        assertEquals("51999447744", outputTwelve.getPhoneNumber());
        assertEquals(date, outputTwelve.getBirthDay());

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
