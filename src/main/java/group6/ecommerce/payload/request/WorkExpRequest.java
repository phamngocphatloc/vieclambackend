package group6.ecommerce.payload.request;

import group6.ecommerce.model.Resume;
import group6.ecommerce.model.Skill;
import group6.ecommerce.model.WorkExp;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
public class WorkExpRequest {
    private String jobLocation;
    private Date dateStart;
    private Date dateEnd;
    private String describe;
    private String achivement;
    private String company;

    public WorkExp getWorkExp (){
        WorkExp workExp = new WorkExp();
        workExp.setJobLocation(this.jobLocation);
        workExp.setDateStart(this.dateStart);
        workExp.setDateEnd(this.dateEnd);
        workExp.setDescribe(this.describe);
        workExp.setAchivement(this.achivement);
        workExp.setCompany(this.company);
        return workExp;
    }
}
