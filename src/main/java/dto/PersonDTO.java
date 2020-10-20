package dto;

import entities.Person;

import java.util.List;

/**
 * @author Joakim
 */
public class PersonDTO {
    private String firstName, lastName, email, phoneNumber, pAddress;
    private List pHobbies;

    //Constructors
    public PersonDTO(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.phoneNumber = person.getPhoneNumber();
        this.pAddress = person.getpAddress();
        this.pHobbies = person.getpHobbies();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public List getpHobbies() {
        return pHobbies;
    }

    public void setpHobbies(List pHobbies) {
        this.pHobbies = pHobbies;
    }
}

