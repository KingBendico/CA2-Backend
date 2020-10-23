package dto;

import entities.Address;
import entities.CityInfo;
import entities.Person;

import java.util.List;

/**
 * @author Joakim
 */
public class CityInfoDTO {
    private String zipCode, city;

    //Constructors

    public CityInfoDTO(CityInfo cityInfo) {
        this.zipCode = cityInfo.getZipCode();
        this.city = cityInfo.getCity();
    }


    //Getters and setters

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

