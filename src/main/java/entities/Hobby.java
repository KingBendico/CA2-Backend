package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/*
* Author:
* Benjamin Choleva, Lasse Emil Støvring Larsen
 */

@Entity
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
 
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id;  
    
    @Id
    @Column(length = 50)
    private String name;
    
    private String wikiLink;
    private String category;
    private String type;
    
    @ManyToMany(mappedBy = "hobbies", cascade = CascadeType.PERSIST)
    private List<Person> persons;
    

    //Constructors
    public Hobby() {
    }

    public Hobby(String hName, String hLink, String hType, String hCategory) {
        this.name = hName;
        this.wikiLink = hLink;
        this.type = hType;
        this.category = hCategory;
    }

    //Getters & Setters
    public String gethName() {
        return name;
    }

    public void sethName(String hName) {
        this.name = hName;
    }

    public String gethWikiLink() {
        return wikiLink;
    }

    public void sethWikiLink(String hWikiLink) {
        this.wikiLink = hWikiLink;
    }

    public String gethCategory() {
        return category;
    }

    public void sethCategory(String hCategory) {
        this.category = hCategory;
    }

    public String gethType() {
        return type;
    }

    public void sethType(String hType) {
        this.type = hType;
    }


    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson (Person person) {
        this.persons.add(person);
    }


    
    

}
