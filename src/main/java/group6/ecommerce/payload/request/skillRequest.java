package group6.ecommerce.payload.request;

import group6.ecommerce.model.Skill;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class skillRequest {
    private String skill;
    public Skill getskill (){
        Skill skills = new Skill();
        skills.setSkillName(skill);
        return skills;
    }
}
