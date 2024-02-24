package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class EducationResume {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "EducationResumeId")
    private int Id;
    @Column (name = "Major",columnDefinition = "nvarchar(255)")
    private String Major;
    @Column (name = "School", columnDefinition = "nvarchar(255)")
    private String school;
    @Column (name = "dateStart")
    private Date dateStart;
    @Column (name = "dateEnd")
    private Date dateEnd;
    @ManyToOne
    @JoinColumn (name = "resumeId")
    private Resume resumeEducation;

    public EducationResume() {
    }

    public EducationResume(int id, String major, String school, Date dateStart, Date dateEnd, Resume resumeEducation) {
        Id = id;
        Major = major;
        this.school = school;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.resumeEducation = resumeEducation;
    }
}
