package facades;

import dto.PersonDTO;
import entities.Hobby;
import entities.Person;
import entities.Phone;

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
        List<PersonDTO> personDTOList;
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = query.getResultList();
            personDTOList = new ArrayList<>();
            persons.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        } finally {
            em.close();
        }
        return personDTOList;
    }

    //TODO public List<PersonDTO> getPersonsByHobby(Hobby hobby)
    public List<PersonDTO> getPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> personDTOList;
        try {
            Query query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name=:hobby");
            query.setParameter("hobby", hobby);
            List<Person> personDetails = query.getResultList();
            personDTOList = new ArrayList<>();
            personDetails.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        } finally {
            em.close();
        }
        return personDTOList;
    }

    //TODO public List<PersonDTO> getPersonsByZip(String zip)
    public List<PersonDTO> getPersonsByZip(String zip) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> personDTOList;
        try {
            Query query = em.createQuery("SELECT p FROM Person p WHERE NOT EXISTS (SELECT a FROM Address a JOIN a.cityInfo c WHERE c.zipCode=:zip)");
            query.setParameter("zip", zip);
            List<Person> personDetails = query.getResultList();
            personDTOList = new ArrayList<>();
            personDetails.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        } finally {
            em.close();
        }
        return personDTOList;
    }

    //Single result methods

    //TODO public PersonDTO getPersonByPhone(String phone)
    public PersonDTO getPersonByPhone(String phone) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query;
        try {
            query = em.createQuery("SELECT pe FROM Person pe JOIN pe.phones ph WHERE NOT EXISTS (SELECT n FROM Phone n WHERE ph = n AND n.number=:phone)", Person.class);
            query.setParameter("phone", phone);
        } finally {
            em.close();
        }
        return new PersonDTO(query.getSingleResult());
    }

    //TODO public PersonDTO addPerson(PersonDTO personDTO)
    public PersonDTO addPerson(PersonDTO personDTO) {
        EntityManager em = emf.createEntityManager();
        Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail());
        person.setAddress(personDTO.getAddress());
        personDTO.getPhones().forEach((Object phone) -> person.addPhone((Phone) phone));
        personDTO.getHobbies().forEach((Object hobby) -> person.addHobby((Hobby) hobby));
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    //TODO public PersonDTO editPerson(long id, PersonDTO personDTO)
    public PersonDTO editPerson(long id, PersonDTO personDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            Person person = em.find(Person.class, id);

            person.setFirstName( personDTO.getFirstName() );
            person.setLastName( personDTO.getLastName() );
            person.setEmail( personDTO.getEmail() );
            person.setAddress( personDTO.getAddress() );
            person.setHobbies( personDTO.getHobbies() );
            person.setPhones( personDTO.getPhones() );

            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();

            return new PersonDTO(person);
        } finally {
            em.close();
        }

    }
}
