package group6.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "CompanyId")
    private int companyId;
    @Column (name = "CompanyName", columnDefinition = "nvarchar(255)", nullable = false, length = 255)
    private String companyName;
    @Column (name = "Locaion", columnDefinition = "nvarchar(255)", nullable = false, length = 255)
    private String companyLocation;
    @Column(name = "Email")
    private String email;
    @Column(name = "Website")
    private String website;
    @Column (name = "Description", columnDefinition = "nvarchar(500)", nullable = false, length = 500)
    private String description;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "UserId")
    private Users userManager;

    public Company (){

    }
    public Company(String companyName, String companyLocation, String email, String website, String description, Users userManager) {
        this.companyName = companyName;
        this.companyLocation = companyLocation;
        this.email = email;
        this.website = website;
        this.description = description;
        this.userManager = userManager;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUserManager() {
        return userManager;
    }

    public void setUserManager(Users userManager) {
        this.userManager = userManager;
    }


}
