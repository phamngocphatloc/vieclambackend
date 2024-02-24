package group6.ecommerce.controller;

import group6.ecommerce.configuration.VnpayConfig;
import group6.ecommerce.model.*;
import group6.ecommerce.payload.request.*;
import group6.ecommerce.payload.response.ResumeRespone;
import group6.ecommerce.service.ResumeService;
import group6.ecommerce.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("resume")
@RequiredArgsConstructor
@Transactional
public class resumeController {
    private final UserService userService;
    private final ResumeService resumeService;
    @PostMapping ("edit")
    public ResponseEntity<ResumeRespone> editResume (@RequestBody ResumeRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = new Resume();
        if (userLogin.getResume() != null) {
             resume = userLogin.getResume();
        }else{
            resume.setUserResume(userLogin);
        }
        resumeService.save(request.getResume(resume));

        ResumeRespone resumeRespone = new ResumeRespone(request.getResume(resume));
        resumeRespone.setStatus("Sửa Thành Công");
        return ResponseEntity.status(HttpStatus.OK).body(resumeRespone);
    }

    @PostMapping ("addSkill")
    @Transactional
    public ResponseEntity<String> addSkill (@RequestBody skillRequest skillRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = userLogin.getResume();
        resumeService.saveSkill(skillRequest.getskill(),resume);
        return ResponseEntity.status(HttpStatus.OK).body("Thêm Thành Công");
    }

    @PostMapping ("addWork")
    @Transactional
    public ResponseEntity<String> addWorkExp (@RequestBody WorkExpRequest workExpRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = userLogin.getResume();
        WorkExp expadd = workExpRequest.getWorkExp();
        expadd.setId(Integer.parseInt(VnpayConfig.getRandomNumber(7)));
        expadd.setResumeWork(resume);
        resumeService.saveWorkExp(expadd);
        return ResponseEntity.status(HttpStatus.OK).body("Thêm Thành Công");
    }
    @PostMapping ("addEdu")
    @Transactional
    public ResponseEntity<String> addEdu (@RequestBody EducationResumeRequest educationResumeRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = userLogin.getResume();
        EducationResume eduadd = educationResumeRequest.get();
        eduadd.setResumeEducation(resume);
        eduadd.setId(Integer.parseInt(VnpayConfig.getRandomNumber(7)));
        resumeService.saveEducation(eduadd);
        return ResponseEntity.status(HttpStatus.OK).body("Thêm Thành Công");
    }
    @PostMapping ("addAward")
    @Transactional
    public ResponseEntity<String> addAward (@RequestBody AwardRequest awardRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = userLogin.getResume();
        AwardsResume award = awardRequest.get();
        award.setAwardResume(resume);
        award.setId(Integer.parseInt(VnpayConfig.getRandomNumber(7)));
        resumeService.saveAward(award);
        return ResponseEntity.status(HttpStatus.OK).body("Thêm Thành Công");
    }
}
