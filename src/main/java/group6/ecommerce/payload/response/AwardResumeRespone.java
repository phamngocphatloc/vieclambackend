package group6.ecommerce.payload.response;

import group6.ecommerce.model.AwardsResume;
import group6.ecommerce.model.Resume;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
public class AwardResumeRespone {
    private int Id;
    private String awardName;
    private String awardContent;

    public AwardResumeRespone(AwardsResume awardsResume) {
        this.Id = awardsResume.getId();
        this.awardName = awardsResume.getAwardName();
        this.awardContent = awardsResume.getAwardContent();
    }
}
