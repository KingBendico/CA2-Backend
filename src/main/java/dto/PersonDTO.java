package dto;

import entities.Address;
import entities.Person;

import java.util.List;

/**
 * @author Joakim
 */
public class PersonDTO {
    private String firstName, lastName, email;
    private Address address;
    private List phones, hobbies;

    //Constructors
    public PersonDTO(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.phones = person.getPhones();
        this.address = person.getAddress();
        this.hobbies = person.getHobbies();
    }

    //Getters and setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List getPhones() {
        return phones;
    }

    public void setPhones(List phones) {
        this.phones = phones;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }
}

