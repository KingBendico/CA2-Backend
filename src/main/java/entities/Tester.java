/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
        Phone ph1 = new Phone("28238182", "mobile");
        Phone ph2 = new Phone("69219912", "home");
                
        
    }
            
    
    
    
    
}
