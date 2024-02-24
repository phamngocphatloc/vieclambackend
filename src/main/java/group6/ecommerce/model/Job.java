package group6.ecommerce.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int jobId;
    @Column (name = "jobName", columnDefinition = "nvarchar(255)" , nullable = false, length = 255)
    private String jobName;
    @Column (name = "img", length = 1000, nullable = false)
    private String img;
    @Column (name = "PriceBefore",nullable = false)
    private int priceBefore;
    @Column (name = "PriceAfter",nullable = false)
    private int priceAfter;
    @Column (name = "Location", columnDefinition = "nvarchar(255)", nullable = false, length = 255)
    private String Location;
    @Column (name = "Date")
    private Date dateJob;
    @Column (name = "Type")
    private String type;
    @Column (name = "Nature")
    private String nature;
    @Column (name = "Vacancy")
    private int vacancy;
    @Column (name = "Description", columnDefinition = "nvarchar(500)", nullable = false, length = 500)
    private String description;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "JobCategory", joinColumns = @JoinColumn(name = "JobId"),inverseJoinColumns = @JoinColumn (name = "CategoryId"))
    private List<Category> jobCategory;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "jobSkill", joinColumns = @JoinColumn(name = "JobId"), inverseJoinColumns = @JoinColumn (name = "SkillId"))
    private List<Skill> jobSkill;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "JobEducation",joinColumns = @JoinColumn (name = "JobId"),inverseJoinColumns = @JoinColumn(name = "EducationId"))
    private List<Education> jobEducation;
    @Column (name = "isRecruiting", columnDefinition = "bit")
    private boolean isRecruiting;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "companyId")
    private Company jobCompany;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "JobApply")
    private List<Apply> Applys;

    public Job (){

    }
    public Job(String jobName, String img, int priceBefore, int priceAfter, String location, Date dateJob, String type, String nature, int vacancy, String description, List<Category> jobCategory, List<Skill> jobSkill, List<Education> jobEducation) {
        this.jobName = jobName;
        this.img = img;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        Location = location;
        this.dateJob = dateJob;
        this.type = type;
        this.nature = nature;
        this.vacancy = vacancy;
        this.description = description;
        this.jobCategory = jobCategory;
        this.jobSkill = jobSkill;
        this.jobEducation = jobEducation;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(int priceBefore) {
        this.priceBefore = priceBefore;
    }

    public int getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(int priceAfter) {
        this.priceAfter = priceAfter;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Date getDateJob() {
        return dateJob;
    }

    public void setDateJob(Date dateJob) {
        this.dateJob = dateJob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(List<Category> jobCategory) {
        this.jobCategory = jobCategory;
    }

    public List<Skill> getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(List<Skill> jobSkill) {
        this.jobSkill = jobSkill;
    }

    public List<Education> getJobEducation() {
        return jobEducation;
    }

    public void setJobEducation(List<Education> jobEducation) {
        this.jobEducation = jobEducation;
    }

    public Company getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(Company jobCompany) {
        this.jobCompany = jobCompany;
    }

    public boolean isRecruiting() {
        return isRecruiting;
    }

    public void setRecruiting(boolean recruiting) {
        isRecruiting = recruiting;
    }

    public List<Apply> getApplys() {
        return Applys;
    }

    public void setApplys(List<Apply> applys) {
        Applys = applys;
    }
}

