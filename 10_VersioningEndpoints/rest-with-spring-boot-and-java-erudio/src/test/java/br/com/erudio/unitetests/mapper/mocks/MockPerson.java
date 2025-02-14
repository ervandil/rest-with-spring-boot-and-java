package br.com.erudio.unitetests.mapper.mocks;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.model.Person;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTOV1 mockDTO() {
        return mockDTO(0);
    }

    public PersonDTOV2 mockDTOV2() {
        return mockDTOV2(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTOV1> mockDTOList() {
        List<PersonDTOV1> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public List<PersonDTOV2> mockDTOV2List() {
        List<PersonDTOV2> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTOV2(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        person.setBirthDay(date);
        return person;
    }

    public PersonDTOV1 mockDTO(Integer number) {
        PersonDTOV1 person = new PersonDTOV1();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTOV2 mockDTOV2(Integer number) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.FEBRUARY, 14, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        PersonDTOV2 person = new PersonDTOV2();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        person.setBirthDay(date);
        return person;
    }

}
