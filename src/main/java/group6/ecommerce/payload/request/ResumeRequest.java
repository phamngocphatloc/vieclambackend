package group6.ecommerce.payload.request;

import group6.ecommerce.model.*;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
@Setter
public class ResumeRequest {
    private String jobPosition;
    private String avatar;
    private String github;
    private String website;
    private String carrer;

    public Resume getResume (Resume resumeold){
        Resume resume = resumeold;
        resume.setJobPosition(jobPosition);
        resume.setAvatar(avatar);
        resume.setGithub(github);
        resume.setWebsite(website);
        resume.setCarrer(carrer);
        return resume;

    }
}
