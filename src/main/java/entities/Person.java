package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/*
* Author:
* Benjamin Choleva, Lasse Emil Støvring Larsen
 */

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    //en til mange
    private String phoneNumber;
    //mange til en
    private String pAddress;
    //mange til mange
    private List pHobbies;

    //Constructors
    public Person() {
    }

    public Person(String firstName, String lastName, String email, String phoneNumber, String pAddress, List pHobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pAddress = pAddress;
        this.pHobbies = pHobbies;
    }

    //Getters & Setters
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

    public Long getId() {
        return id;
    }

}
