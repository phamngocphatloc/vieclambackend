package group6.ecommerce.controller;


import group6.ecommerce.model.Apply;
import group6.ecommerce.model.Users;
import group6.ecommerce.payload.request.ChangePasswordRequest;
import group6.ecommerce.payload.request.UserInfoRequest;
import group6.ecommerce.payload.response.*;
import group6.ecommerce.service.ApplyService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import group6.ecommerce.payload.request.LoginRequest;
import group6.ecommerce.payload.request.UserRequest;
import group6.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Transactional
public class UserController {
    private final UserService userService;
    private final ApplyService applyService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
    }

    @PostMapping("register")
    @Transactional
    public ResponseEntity<HttpResponse> register(@RequestBody UserRequest userRequest) {
        userService.register(userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),
                "Register successfully",null));
    }

    @GetMapping("getUserByEmail/{email}")
    public ResponseEntity<UserDetailsResponse> findUserByEmail(@PathVariable String email){
        Users user = userService.findByEmail(email);
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDetailsResponse);
    }


    @PostMapping("changePassword")
    public ResponseEntity<HttpResponse> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        Boolean changePassword = userService.changePassword(changePasswordRequest);
        if(changePassword){
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),
                    "Change password successfully",null));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),
                    "Wrong old password or the new password and confirm password do not match",null));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<HttpResponse> update(@PathVariable("id") int id, @RequestBody UserInfoRequest userInfoRequest){
        try{
            Users user = userService.findById(userInfoRequest.getUserId());

            if(user == null){
                return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),
                        "User not found",null));
            }
            userService.update(userInfoRequest.getUserId(), userInfoRequest);
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponse(HttpStatus.OK.value(),
                    "Update successfully",null));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HttpResponse(HttpStatus.BAD_REQUEST.value(),
                    "Update failed",null));
        }
    }

    @GetMapping ("authorization")
    public ResponseEntity<UserDetailsResponse> getRoleUset (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        roleRespone role = new roleRespone(userLogin.getEmail(),userLogin.getRole().getRoleName());
        return ResponseEntity.status(HttpStatus.OK).body(new UserDetailsResponse(userLogin));
    }

    @GetMapping ("resume")
    public ResponseEntity<ResumeRespone> getResume (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        ResumeRespone resume = new ResumeRespone();
        resume.setStatus("Chưa có thông tin");
        if (userLogin.getResume()!=null) {
             resume = new ResumeRespone(userLogin.getResume());

        }
        return ResponseEntity.status(HttpStatus.OK).body(resume);
    }

    @GetMapping ("getapplys")
    public ResponseEntity<List<applyRespone>> getApplys (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());

        List<applyRespone> list = new ArrayList<>();
        List<Apply> listapply = applyService.selectApplysByUser(userLogin);
        listapply.stream().forEach(item -> {
            list.add(new applyRespone(item));
        });
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
