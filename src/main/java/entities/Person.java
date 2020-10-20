package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
  
  
    //mange til en
   // private String pAddress;
    
    
    //mange til mange
  //  private List pHobbies;
    
      //en til mange
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Phone> phones;

    //mange til en
    @ManyToOne
    private Address address;
    
    //en til mange
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
     private List<Hobby> hobbies;
    
    
    //Constructors
    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Long getId() {
        return id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public Address getAddress() {
        return address;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

 
}
