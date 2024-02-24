package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class AwardsResume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AwardsResumeId")
    private int Id;
    @Column (name = "AwardName", columnDefinition = "nvarchar(255)")
    private String awardName;
    @Column (name = "AwardContent", columnDefinition = "nvarchar(255)")
    private String awardContent;
    @ManyToOne
    @JoinColumn (name = "resumeId")
    private Resume awardResume;

    public AwardsResume() {
    }

    public AwardsResume(int id, String awardName, String awardContent, Resume awardResume) {
        Id = id;
        this.awardName = awardName;
        this.awardContent = awardContent;
        this.awardResume = awardResume;
    }
}
