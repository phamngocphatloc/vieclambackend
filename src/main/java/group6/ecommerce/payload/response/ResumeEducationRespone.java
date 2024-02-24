package group6.ecommerce.payload.response;

import group6.ecommerce.model.EducationResume;
import group6.ecommerce.model.Resume;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
@Getter
public class ResumeEducationRespone {
    private int Id;
    private String Major;
    private String school;
    private Date dateStart;
    private Date dateEnd;

    public ResumeEducationRespone(EducationResume educationResume) {
        this.Id = educationResume.getId();
        this.Major = educationResume.getMajor();
        this.school = educationResume.getSchool();
        this.dateStart = educationResume.getDateStart();
        this.dateEnd = educationResume.getDateEnd();
    }
}
