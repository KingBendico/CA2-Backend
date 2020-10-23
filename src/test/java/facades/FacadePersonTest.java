package facades;

import dto.PersonDTO;
import entities.*;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadePersonTest {

    private static EntityManagerFactory emf;
    private static FacadePerson facade;

    private Person p1, p2, p3, p4;

    public FacadePersonTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = FacadePerson.getFacadePerson(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        p1 = new Person("Joakim", "Stensnaes", "joakim@mail.dk");
        p2 = new Person("Benjamin", "Benzo", "benzo@mail.dk");
        p3 = new Person("Thor", "Thorsten", "thorsten@thor.dk");
        p4 = new Person("Lars", "Larsen", "lars@mail.dk");

        Hobby h1 = new Hobby("Acting", "", "", "");
        Hobby h2 = new Hobby("Baking", "", "", "");
        Hobby h3 = new Hobby("Cooking", "", "", "");

        Address a1 = new Address("Bagervej 12", "N/A");
        Address a2 = new Address("Krystalgade 40", "N/A");

        CityInfo c1 = new CityInfo("2200", "København N");
        CityInfo c2 = new CityInfo("2400", "København N");

        Phone ph1 = new Phone("20202020", "");
        Phone ph2 = new Phone("30303030", "");
        Phone ph3 = new Phone("40404040", "");
        Phone ph4 = new Phone("50505050", "");
        Phone ph5 = new Phone("60606060", "");

        p1.addHobby(h1);
        p1.addHobby(h2);
        p2.addHobby(h1);
        p3.addHobby(h2);
        p3.addHobby(h3);
        p4.addHobby(h1);
        p4.addHobby(h2);
        p4.addHobby(h3);

        a1.setCityInfo(c1);
        a2.setCityInfo(c2);

        p1.setAddress(a1);
        p2.setAddress(a1);
        p3.setAddress(a2);
        p4.setAddress(a2);

        p1.addPhone(ph1);
        p1.addPhone(ph2);
        p2.addPhone(ph3);
        p3.addPhone(ph4);
        p4.addPhone(ph5);

        try {
            em.getTransaction().begin();
            em.createQuery("DELETE from CityInfo").executeUpdate();
            em.createQuery("DELETE from Address").executeUpdate();
            em.createQuery("DELETE from Hobby").executeUpdate();
            em.createQuery("DELETE from Phone").executeUpdate();
            em.createQuery("DELETE from Person").executeUpdate();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        //Remove any data after each test was run
    }

    @Test
    public void testGetPersons() {
        assertEquals(4, facade.getPersons().size(), "Expects four members in the database");
    }

    @Test
    public void testGetPersonsByHobby() {
        assertEquals(3, facade.getPersonsByHobby("Baking").size(), "Expects three differen members sharing the same hobby 'Baking'");
    }

    @Test
    public void testGetPersonsByZip() {
        assertEquals(2, facade.getPersonsByZip("2200").size(), "Expects two differen members sharing the same zipcode '2200'");
    }

    @Test
    public void testGetSamePersonByPhone() {
        PersonDTO p1 = facade.getPersonByPhone("20202020");
        PersonDTO p2 = facade.getPersonByPhone("30303030");
        assertEquals(p1.getEmail(), p2.getEmail(), "Expects the email address of the two different objects, to be equal, as the two different phone numbers are assigned to the same person");
    }

    @Test
    public void testGetDifferentPersonByPhone() {
        PersonDTO p1 = facade.getPersonByPhone("20202020");
        PersonDTO p2 = facade.getPersonByPhone("50505050");
        assertNotEquals(p1.getEmail(), p2.getEmail(), "Expects the email address of the two different objects, to be not be equal, as the two different phone numbers are assigned to different persons");
    }

    @Test
    public void testAddPerson() {
        Person p5 = new Person("Lars", "Larsen", "lars@mail.dk");
        Address a2 = new Address("Tagensvej 110", "N/A");
        Phone ph1 = new Phone("80808080", "");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p5);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        assertEquals(5, facade.getPersons().size(), "Expects the list of persons recieved from the database, to be 5, after adding an additional person");
    }

    //TODO public void testEditPerson()
    @Test
    public void testEditPerson() {
        /*p2.addPhone(new Phone("90909090",""));
        facade.editPerson(2, new PersonDTO(p2));
        List<Phone> phones = facade.getPersonByPhone("90909090").getPhones();
        assertEquals("90909090", phones.forEach(phone -> phone.getNumber()));*/
    }
}
