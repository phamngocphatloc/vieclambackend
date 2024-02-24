package group6.ecommerce.controller;

import group6.ecommerce.model.Apply;
import group6.ecommerce.model.Job;
import group6.ecommerce.model.Resume;
import group6.ecommerce.model.Users;
import group6.ecommerce.payload.response.HttpResponse;
import group6.ecommerce.service.ApplyService;
import group6.ecommerce.service.JobService;
import group6.ecommerce.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Transactional
public class ApplyController {
    private final ApplyService applyService;
    private final UserService userService;
    private final JobService jobService;
    @PostMapping ("apply")
    public ResponseEntity<HttpResponse> apply (@RequestParam ("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        Resume resume = userLogin.getResume();
        Apply apply = new Apply();
        apply.setUserApply(userLogin);
        Job job = jobService.SelectById(id);
        apply.setJobApply(job);
        applyService.save(apply);
        HttpResponse respone = new HttpResponse(HttpStatus.OK.value(),"Apply Thành Công",null);
        return ResponseEntity.status(HttpStatus.OK).body(respone);
    }

    @DeleteMapping ("apply")
    public ResponseEntity<HttpResponse> deleApply (@RequestParam("id") int id){
        Apply apply = applyService.selectById(id);
        applyService.delebeAplly(apply);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),"Xóa Thành Công",null));
    }
}
