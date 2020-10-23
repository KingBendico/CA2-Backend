package facades;

import dto.CityInfoDTO;
import dto.HobbyDTO;
import entities.CityInfo;
import entities.Hobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Joakim
 */
public class FacadeHobby {

    private static FacadeHobby instance;
    private static EntityManagerFactory emf;
    private long hobbyCount;

    //Private Constructor to ensure Singleton
    private FacadeHobby() {
    }

    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeHobby getFacadeHobby(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeHobby();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getHobbyCount() {
        EntityManager em = emf.createEntityManager();
        try {
            hobbyCount = (long) em.createQuery("SELECT COUNT(h) FROM Hobby h").getSingleResult();
            return hobbyCount;
        } finally {
            em.close();
        }
    }

    //Multi result methods

    //TODO getHobbies()
    public List<HobbyDTO> getHobbies() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Hobby> query = em.createQuery("SELECT h FROM Hobby h", Hobby.class);
        List<Hobby> hobbies = query.getResultList();
        List<HobbyDTO> hobbyDTOList = new ArrayList<>();
        hobbies.forEach((Hobby hobby) -> hobbyDTOList.add(new HobbyDTO(hobby)));
        return hobbyDTOList;
    }
}
