package group6.ecommerce.payload.response;

import group6.ecommerce.model.Resume;
import group6.ecommerce.model.Skill;
import group6.ecommerce.model.WorkExp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class WorkExpRespone {
    private String jobLocation;
    private Date dateStart;
    private Date dateEnd;
    private String describe;
    private String achivement;
    private List<String> skills = new ArrayList<>();
    private String company;

    public WorkExpRespone(WorkExp workExp) {
        this.jobLocation = workExp.getJobLocation();
        this.dateStart = workExp.getDateStart();
        this.dateEnd = workExp.getDateEnd();
        this.describe = workExp.getDescribe();
        this.achivement = workExp.getAchivement();
        workExp.getSkills().stream().forEach(item -> {
            this.skills.add(item.getSkillName());
        });
        this.company = workExp.getCompany();
    }
}
