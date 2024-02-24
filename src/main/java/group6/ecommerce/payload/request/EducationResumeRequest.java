package group6.ecommerce.payload.request;

import group6.ecommerce.model.EducationResume;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;

import java.util.Date;
@Setter
public class EducationResumeRequest {
    private String major;
    private String school;
    private Date dateStart;
    private Date dateEnd;

    public EducationResume get(){
        EducationResume edu = new EducationResume();
        edu.setMajor(major);
        edu.setSchool(school);
        edu.setDateStart(dateStart);
        edu.setDateEnd(dateEnd);
        return edu;
    }
}
