package group6.ecommerce.payload.request;

import group6.ecommerce.model.AwardsResume;
import group6.ecommerce.model.Resume;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Setter;

@Setter

public class AwardRequest {
    private String awardName;
        private String awardContent;
    public AwardsResume get (){
        AwardsResume award = new AwardsResume();
        award.setAwardName(awardName);
        award.setAwardContent(awardContent);
        return award;
    }
}
