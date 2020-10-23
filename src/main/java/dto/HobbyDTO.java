package dto;

import entities.CityInfo;
import entities.Hobby;

/**
 * @author Joakim
 */
public class HobbyDTO {
    private String hName, hWikiLink, hCategory, hType;

    //Constructors
    public HobbyDTO(Hobby hobby) {
        this.hName = hobby.gethName();
        this.hWikiLink = hobby.gethWikiLink();
        this.hCategory = hobby.gethCategory();
        this.hType = hobby.gethType();
    }


    //Getters and setters
    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String gethWikiLink() {
        return hWikiLink;
    }

    public void sethWikiLink(String hWikiLink) {
        this.hWikiLink = hWikiLink;
    }

    public String gethCategory() {
        return hCategory;
    }

    public void sethCategory(String hCategory) {
        this.hCategory = hCategory;
    }

    public String gethType() {
        return hType;
    }

    public void sethType(String hType) {
        this.hType = hType;
    }
}

