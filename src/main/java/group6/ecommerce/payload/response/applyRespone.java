package group6.ecommerce.payload.response;

import group6.ecommerce.model.Apply;
import lombok.Getter;

@Getter
public class applyRespone {
    private int id;
    private JobRespone job;
    private UserDetailsResponse user;
    private ResumeRespone resume;

    public applyRespone(Apply apply) {
        this.id = apply.getId();
        this.job = new JobRespone(apply.getJobApply());
        this.user = new UserDetailsResponse(apply.getUserApply());
        this.resume = new ResumeRespone(apply.getUserApply().getResume());
    }
}
