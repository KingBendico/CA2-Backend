package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
* Author:
* Benjamin Choleva, Lasse Emil Støvring Larsen
 */
@Entity
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String hName;
    private String hWikiLink;
    private String hCategory;
    private String hType;

    public Hobby() {
    }

    public Hobby(String hName, String hLink, String hType, String hCategory) {
        this.hName = hName;
        this.hWikiLink = hLink;
        this.hType = hType;
        this.hCategory = hCategory;
    }

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

    public Long getId() {
        return id;
    }

}
