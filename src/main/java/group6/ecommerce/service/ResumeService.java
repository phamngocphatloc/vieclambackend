package group6.ecommerce.service;

import group6.ecommerce.model.*;

public interface ResumeService {
    public void save(Resume resume);
    public void saveSkill(Skill skill, Resume resume);
    public void saveWorkExp (WorkExp exp);
    public void saveEducation (EducationResume edu);
    public void saveAward (AwardsResume award);
}
