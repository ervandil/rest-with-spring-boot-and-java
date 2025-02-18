package br.com.erudio.services;

import br.com.erudio.data.dto.v2.PersonDTOV2;
import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.exception.RequiredObjectIsNullException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import br.com.erudio.unitetests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;
    @InjectMocks
    private PersonServices service;
    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUp() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByIdV3() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        var result = service.findByIdV3(1L);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
        assertEquals("51999447744", result.getPhoneNumber());

    }

    @Test
    void findByIdV2() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        var result = service.findByIdV2(1L);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v2/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v2/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());

    }

    @Test
    void createV3() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTOV3 dto = input.mockDTOV3(1);
        when(repository.save(person)).thenReturn(persisted);
        var result = service.createV3(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
        assertEquals("51999447744", result.getPhoneNumber());
    }

    @Test
    void createV2() {
        Person person = input.mockEntityV2(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTOV2 dto = input.mockDTOV2(1);
        when(repository.save(person)).thenReturn(persisted);
        var result = service.createV2(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.createV3(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void updateV3() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTOV3 dto = input.mockDTOV3(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(person)).thenReturn(persisted);
        var result = service.updateV3(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
        assertEquals("51999447744", result.getPhoneNumber());
    }

    @Test
    void updateV2() {
        Person person = input.mockEntityV2(1);
        Person persisted = person;
        persisted.setId(1L);

        PersonDTOV2 dto = input.mockDTOV2(1);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        when(repository.save(person)).thenReturn(persisted);
        var result = service.updateV2(dto);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getLinks());

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        result.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
        assertEquals("Female", result.getGender());
    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.updateV3(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Person person = input.mockEntity(1);
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));
        service.delete(1L);
        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any(Person.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void findAllV2() {
        List<Person> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<PersonDTOV2> people = service.findAllV2();
        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(1);
        assertNotNull(personOne);
        assertNotNull(personOne.getId());
        assertNotNull(personOne.getLinks());

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v2/1")
                && link.getType().equals("GET"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("GET"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("POST"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("PUT"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v2/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", personOne.getAddress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());

        var personFour = people.get(4);
        assertNotNull(personFour);
        assertNotNull(personFour.getId());
        assertNotNull(personFour.getLinks());

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v2/4")
                && link.getType().equals("GET"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("GET"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("POST"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("PUT"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v2/4")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test4", personFour.getAddress());
        assertEquals("First Name Test4", personFour.getFirstName());
        assertEquals("Last Name Test4", personFour.getLastName());
        assertEquals("Male", personFour.getGender());

        var personSeven = people.get(7);
        assertNotNull(personSeven);
        assertNotNull(personSeven.getId());
        assertNotNull(personSeven.getLinks());

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v2/7")
                && link.getType().equals("GET"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("GET"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("POST"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v2")
                && link.getType().equals("PUT"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v2/7")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test7", personSeven.getAddress());
        assertEquals("First Name Test7", personSeven.getFirstName());
        assertEquals("Last Name Test7", personSeven.getLastName());
        assertEquals("Female", personSeven.getGender());
    }

    @Test
    void findAllV3() {
        List<Person> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);
        List<PersonDTOV3> people = service.findAllV3();
        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(1);
        assertNotNull(personOne);
        assertNotNull(personOne.getId());
        assertNotNull(personOne.getLinks());

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("GET"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        personOne.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/1")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test1", personOne.getAddress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());
        assertEquals("51999447744", personOne.getPhoneNumber());

        var personFour = people.get(4);
        assertNotNull(personFour);
        assertNotNull(personFour.getId());
        assertNotNull(personFour.getLinks());

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/4")
                && link.getType().equals("GET"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        personFour.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/4")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test4", personFour.getAddress());
        assertEquals("First Name Test4", personFour.getFirstName());
        assertEquals("Last Name Test4", personFour.getLastName());
        assertEquals("Male", personFour.getGender());
        assertEquals("51999447744", personFour.getPhoneNumber());

        var personSeven = people.get(7);
        assertNotNull(personSeven);
        assertNotNull(personSeven.getId());
        assertNotNull(personSeven.getLinks());

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("self")
                && link.getHref().endsWith("api/person/v3/7")
                && link.getType().equals("GET"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("findAll")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("GET"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("create")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("POST"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("update")
                && link.getHref().endsWith("api/person/v3")
                && link.getType().equals("PUT"));

        personSeven.getLinks().stream().anyMatch(link -> link.getRel().value().equals("delete")
                && link.getHref().endsWith("api/person/v3/7")
                && link.getType().equals("DELETE"));

        assertEquals("Address Test7", personSeven.getAddress());
        assertEquals("First Name Test7", personSeven.getFirstName());
        assertEquals("Last Name Test7", personSeven.getLastName());
        assertEquals("Female", personSeven.getGender());
        assertEquals("51999447744", personSeven.getPhoneNumber());
    }
}