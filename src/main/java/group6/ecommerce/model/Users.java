package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer id;
    @Column (name = "fullName", columnDefinition = "nvarchar(50)", length = 255)
    private String fullName;
    @Column(name = "Email", nullable = false, unique = true, length = 50)
    private String email;
    @Column(name = "Phone", nullable = false, unique = true, length = 50)
    private String phone;
    @Column(name = "Password", nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;
    @Column(name = "Address", columnDefinition = "nvarchar(500)", nullable = false, length = 500)
    private String address;
    @Column(name = "City",columnDefinition = "nvarchar(50)", nullable = false, length = 50)
    private String city;
    @Column(name = "District", columnDefinition = "nvarchar(50)", nullable = false, length = 50)
    private String district;
    @Column(name = "Ward",columnDefinition = "nvarchar(50)", nullable = false, length = 50)
    private String ward;

    @OneToOne (fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "userResume")
    Resume resume;

    @OneToMany (mappedBy = "userManager", fetch = FetchType.EAGER)
    List<Company> companyList;


    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getFullName() {
        return fullName;
    }

    public Resume getResume() {
        return resume;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }
}
