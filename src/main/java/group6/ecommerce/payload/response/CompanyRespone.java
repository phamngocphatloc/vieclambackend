package group6.ecommerce.payload.response;

import group6.ecommerce.model.Company;
import group6.ecommerce.model.Users;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
public class CompanyRespone {

    private int companyId;
    private String companyName;
    private String companyLocation;
    private String email;
    private String website;
    private String description;

    private List<JobRespone> jobs;
    private UserDetailsResponse userManager;

    public CompanyRespone (Company company){
        this.companyId = company.getCompanyId();
        this.companyLocation = company.getCompanyLocation();
        this.email = company.getEmail();
        this.website = company.getWebsite();
        this.description = company.getDescription();
        this.userManager = new UserDetailsResponse(company.getUserManager());
        this.companyName = company.getCompanyName();

    }
}
