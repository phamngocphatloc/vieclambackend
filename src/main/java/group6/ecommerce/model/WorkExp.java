package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
@Entity
public class WorkExp {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "WorkExpId")
    private int id;
    @Column (name = "JobLocation",columnDefinition = "nvarchar(50)")
    private String jobLocation;
    @Column (name = "DateStart")
    private Date dateStart;
    @Column (name = "DateEnd")
    private Date dateEnd;
    @Column (name = "Describe", columnDefinition = "nvarchar(500)")
    private String describe;
    @Column (name = "Achievement", columnDefinition = "nvarchar(500)")
    private String achivement;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "WorkExpSkill" , joinColumns = @JoinColumn (name = "workExpId"), inverseJoinColumns = @JoinColumn (name = "skillId"))
    private List<Skill> skills;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "ResumeId")
    private Resume resumeWork;

    @Column (name = "Company", columnDefinition = "nvarchar(255)")
    private String company;

    public WorkExp() {
    }

    public WorkExp(int id, String jobLocation, Date dateStart, Date dateEnd, String describe, String achivement, List<Skill> skills, Resume resumeWork) {
        this.id = id;
        this.jobLocation = jobLocation;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.describe = describe;
        this.achivement = achivement;
        this.skills = skills;
        this.resumeWork = resumeWork;
    }
}
