package facades;

import dto.CityInfoDTO;
import dto.PersonDTO;
import entities.CityInfo;
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
public class FacadeCityInfo {

    private static FacadeCityInfo instance;
    private static EntityManagerFactory emf;
    private long cityInfoCount;

    //Private Constructor to ensure Singleton
    private FacadeCityInfo() {
    }

    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeCityInfo getFacadeCityInfo(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeCityInfo();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getCityInfoCount() {
        EntityManager em = emf.createEntityManager();
        try {
            cityInfoCount = (long) em.createQuery("SELECT COUNT(c) FROM CityInfo c").getSingleResult();
            return cityInfoCount;
        } finally {
            em.close();
        }
    }

    //Multi result methods

    //TODO getCityInfos()
    public List<CityInfoDTO> getCityInfos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CityInfo> query = em.createQuery("SELECT c FROM CityInfo c", CityInfo.class);
        List<CityInfo> cityInfos = query.getResultList();
        List<CityInfoDTO> cityInfoDTOList = new ArrayList<>();
        cityInfos.forEach((CityInfo cityInfo) -> cityInfoDTOList.add(new CityInfoDTO(cityInfo)));
        return cityInfoDTOList;
    }
}
