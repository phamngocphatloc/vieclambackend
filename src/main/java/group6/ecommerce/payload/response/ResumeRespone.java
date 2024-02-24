package group6.ecommerce.payload.response;

import group6.ecommerce.model.*;
import jakarta.persistence.*;
import lombok.Getter;
import org.eclipse.angus.mail.imap.ResyncData;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ResumeRespone {
    private String jobPosition;
    private String avatar;
    private String github;
    private String website;
    private String carrer;
    private List<WorkExpRespone> WorkExps = new ArrayList<>();
    private List<String> skills = new ArrayList<>();

    private List<ResumeEducationRespone> educations = new ArrayList<>();

    private String status;
    private List<AwardResumeRespone> awards = new ArrayList<>();
    public ResumeRespone() {
    }

    public ResumeRespone(Resume resume) {
        this.jobPosition = resume.getJobPosition();
        this.avatar = resume.getAvatar();
        this.github = resume.getGithub();
        this.website = resume.getWebsite();
        this.carrer = resume.getCarrer();
        resume.getWorkExps().stream().forEach(item -> {
            this.WorkExps.add(new WorkExpRespone(item));
        });
        resume.getSkills().stream().forEach(item -> {
            this.skills.add(item.getSkillName());
        });

        resume.getEducations().stream().forEach(item -> {
            this.educations.add(new ResumeEducationRespone(item));
        });
        resume.getAwards().stream().forEach(item -> {
            this.awards.add(new AwardResumeRespone(item));
        });

    }

    public void setStatus(String status) {
        this.status = status;
    }
}
