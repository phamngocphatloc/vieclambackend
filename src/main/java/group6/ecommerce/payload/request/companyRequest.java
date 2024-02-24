package group6.ecommerce.payload.request;

import group6.ecommerce.model.Company;
import group6.ecommerce.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class companyRequest {
    private String companyName;
    private String companyLocation;
    private String description;
    private String website;
    private Users user;
    public Company getcomCompany (){
        Company company = new Company();
        company.setCompanyName(this.companyName);
        company.setCompanyLocation(this.companyLocation);
        company.setDescription(description);
        company.setEmail(user.getEmail());
        company.setWebsite(website);
        company.setUserManager(user);
        return company;
    }
}
