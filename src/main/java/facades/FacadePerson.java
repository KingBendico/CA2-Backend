package facades;

import dto.PersonDTO;
import dto.PersonHobbyDTO;
import entities.Hobby;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joakim
 */
public class FacadePerson {

    private static FacadePerson instance;
    private static EntityManagerFactory emf;
    private long personCount;

    //Private Constructor to ensure Singleton
    private FacadePerson() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadePerson getFacadePerson(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadePerson();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            personCount = (long) em.createQuery("SELECT COUNT(p) FROM Person p").getSingleResult();
            return personCount;
        } finally {
            em.close();
        }
    }

    //Multi result methods

    //TODO getPersons()
    public List<PersonDTO> getPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> persons = query.getResultList();
        List<PersonDTO> personDTOList = new ArrayList<>();
        persons.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        return personDTOList;
    }

    //TODO public List<PersonDTO> getPersonsByHobby(Hobby hobby)
    public List<PersonDTO> getPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.hName=:hobby");
        List<Person> personDetails = query.getResultList();
        List<PersonDTO> personDTOList = new ArrayList<>();
        personDetails.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        return personDTOList;
    }

    //TODO public List<PersonDTO> getPersonsByZip(String zip)
    public List<PersonDTO> getPersonsByZip(String zip) {
        EntityManager em = emf.createEntityManager();
        //Query query = em.createQuery("SELECT p FROM Person p JOIN p.address a WHERE NOT EXISTS (SELECT b FROM Address b JOIN b.cityInfo c WHERE c.zipcode=:zip)");
        Query query = em.createQuery("SELECT p FROM Person p WHERE NOT EXISTS (SELECT a FROM Address a JOIN a.cityInfo c WHERE c.zipCode=:zip)");
        List<Person> personDetails = query.getResultList();
        List<PersonDTO> personDTOList = new ArrayList<>();
        personDetails.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        return personDTOList;
    }

    //Single result methods

    //TODO public PersonDTO getPersonByPhone(String phone)
    //TODO public PersonDTO addPerson(PersonDTO person)
    //TODO public PersonDTO editPerson(PersonDTO person)
}
