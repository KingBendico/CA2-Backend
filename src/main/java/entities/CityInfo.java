package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
* Author:
* Benjamin Choleva, Lasse Emil Støvring Larsen
 */


//test comment

@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    
  
    @Id
    @Column(length = 4)
    private String zipCode;

    @Column(length = 35)
    private String city;
    
 @OneToMany(mappedBy = "cityInfo", cascade = CascadeType.PERSIST)
    private List<Address> addresses;
 
    //Constructors
    public CityInfo() {
    }
    
  
    public CityInfo(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        this.addresses = new ArrayList<>();
    }
    
   
    
    

    //Getters & Setters
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



    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }
    

}
