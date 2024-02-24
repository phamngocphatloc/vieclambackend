package group6.ecommerce.payload.response;

import group6.ecommerce.model.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
public class JobRespone {
    private int jobId;
    private String jobName;
    private String img;
    private int priceBefore;
    private int priceAfter;
    private String Location;
    private Date dateJob;
    private String type;
    private String nature;
    private int vacancy;
    private String description;
    private List<String> jobCategory = new ArrayList<>();
    private List<String> jobSkill = new ArrayList<>();
    private List<String> jobEducation = new ArrayList<>();
    private boolean isRecruiting;
    private CompanyRespone jobCompany;
    public JobRespone (Job job){
        this.jobId = job.getJobId();
        this.jobName = job.getJobName();
        this.img = job.getImg();
        this.priceBefore = job.getPriceBefore();
        this.priceAfter = job.getPriceAfter();
        this.Location = job.getLocation();
        this.dateJob = job.getDateJob();
        this.type = job.getType();
        this.nature = job.getNature();
        this.vacancy = job.getVacancy();
        this.description = job.getDescription();

        job.getJobCategory().stream().forEach(item -> {
            this.jobCategory.add(item.getName());
        });
        job.getJobSkill().stream().forEach(item -> {
            this.jobSkill.add(item.getSkillName());
        });
        job.getJobEducation().stream().forEach(item -> {
            this.jobEducation.add(item.getEducationName());
        });
        this.jobCompany = new CompanyRespone(job.getJobCompany());
        this.isRecruiting = job.isRecruiting();
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

    public List<String> getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(List<String> jobCategory) {
        this.jobCategory = jobCategory;
    }

    public List<String> getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(List<String> jobSkill) {
        this.jobSkill = jobSkill;
    }

    public List<String> getJobEducation() {
        return jobEducation;
    }

    public void setJobEducation(List<String> jobEducation) {
        this.jobEducation = jobEducation;
    }

    public boolean isRecruiting() {
        return isRecruiting;
    }

    public void setRecruiting(boolean recruiting) {
        isRecruiting = recruiting;
    }

    public CompanyRespone getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(CompanyRespone jobCompany) {
        this.jobCompany = jobCompany;
    }
}
