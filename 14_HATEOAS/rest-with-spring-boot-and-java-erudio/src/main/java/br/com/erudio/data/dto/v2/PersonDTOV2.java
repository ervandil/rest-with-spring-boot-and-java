package br.com.erudio.data.dto.v2;

import br.com.erudio.data.dto.v3.PersonDTOV3;
import br.com.erudio.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id","first_name","last_name","address","birthDay","gender"})
public class PersonDTOV2 extends RepresentationModel<PersonDTOV2> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    //    @JsonProperty("first_name")
    private String firstName;
    //    @JsonProperty("last_name")
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
    private String address;
    //    @JsonIgnore
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    public PersonDTOV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDay, that.birthDay) && Objects.equals(address, that.address) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDay, address, gender);
    }
}
