package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Resume {
    @Id
    @Column (name = "ResumeId")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int resumeId;
    @Column (name = "JobPosition",columnDefinition = "nvarchar(50)")
    private String jobPosition;
    @Column (name = "avt", length = 500)
    private String avatar;
    @Column (name = "GitHub")
    private String github;
    @Column (name = "Website")
    private String website;
    @Column (name = "Carrer",columnDefinition = "nvarchar(500)")
    private String carrer;
    @OneToMany (mappedBy = "resumeWork", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WorkExp> WorkExps = new ArrayList<>();;
    @ManyToMany (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable (name = "ResumeSkill" , joinColumns = @JoinColumn (name = "resumeId"), inverseJoinColumns = @JoinColumn (name = "skillId"))
    private List<Skill> skills = new ArrayList<>();;
    @OneToMany (mappedBy = "resumeEducation",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<EducationResume> educations;

    @OneToMany (mappedBy = "awardResume",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AwardsResume> awards = new ArrayList<>();
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "userId")
    private Users userResume;

    public Resume() {
    }

    public Resume(int resumeId, String jobPosition, String avatar, String github, String website, String carrer, List<WorkExp> workExps, List<Skill> skills, List<EducationResume> educations, Users user) {
        this.resumeId = resumeId;
        this.jobPosition = jobPosition;
        this.avatar = avatar;
        this.github = github;
        this.website = website;
        this.carrer = carrer;
        WorkExps = workExps;
        this.skills = skills;
        this.educations = educations;
        this.userResume = user;
    }
}
