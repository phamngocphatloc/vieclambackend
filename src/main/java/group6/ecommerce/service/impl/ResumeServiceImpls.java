package group6.ecommerce.service.impl;

import group6.ecommerce.Repository.*;
import group6.ecommerce.configuration.VnpayConfig;
import group6.ecommerce.model.*;
import group6.ecommerce.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpls implements ResumeService {
    private final ResumeRepository resumeRepository;
    private final SkillRepository skillRepository;
    private final WorkExpRepository workExpRepository;
    private final AwardResumeRepository awardResumeRepository;
    private final EducationResumeRepository educationResumeRepository;

    @Override
    public void save(Resume resume) {
        resumeRepository.saveAndFlush(resume);
    }

    @Override
    public void saveSkill(Skill skill, Resume resume) {
        if (skillRepository.findBySkillNameLike(skill.getSkillName())==null){
            Skill skillsave = new Skill();
            skillsave.setSkillId(Integer.parseInt(VnpayConfig.getRandomNumber(7)));
            skillsave.setSkillName(skill.getSkillName());
            System.out.println(skillsave.getSkillName());
            System.out.println("helo");
            skillRepository.save(skillsave);

        }
        Skill skillget = skillRepository.findBySkillNameLike(skill.getSkillName());
        resume.getSkills().add(skillget);
        resumeRepository.save(resume);

    }

    @Override
    public void saveWorkExp(WorkExp exp) {
        workExpRepository.save(exp);
    }

    @Override
    public void saveEducation(EducationResume edu) {
        educationResumeRepository.save(edu);
    }

    @Override
    public void saveAward(AwardsResume award) {
        awardResumeRepository.save(award);
    }
}
