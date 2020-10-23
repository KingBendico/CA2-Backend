
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bendico
 */
public class Tester {
    
    public static void main(String[] args) {
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("Bob", "Lasseboy", "bob@lasseboy.dk");
        Person p2 = new Person("Bob", "benjiboy", "bob@benjiboy.dk");
       
        
//        Phone ph1 = new Phone("28238182", "mobile");
//        Phone ph2 = new Phone("69219912", "home");
//        
//        Hobby h1 = new Hobby("YourMom", "wikiLinkweeee", "outdoors", "general");
//        Hobby h2 = new Hobby("Yourdad", "wikiLinkweeee", "indoors", "science");
//        
//        Address a1 = new Address("Andegade 12", "Home");
//        Address a2 = new Address("Mereslik 25", "Office");
//        
//        CityInfo c1 = new CityInfo("2920", "Charlottenlund");
//        CityInfo c2 = new CityInfo("2820", "Gentofte");
        

        
            try { 
            em.getTransaction().begin();
                em.persist(p1);
                em.persist(p2);
//                em.persist(ph1);
//                em.persist(ph2);
//                em.persist(h1);
//                em.persist(h2);
//                em.persist(a1);
//                em.persist(a2);
//                em.persist(c1);
//                em.persist(c2);
        
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
    }
            
    
    
    
    
}
