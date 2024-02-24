package group6.ecommerce.controller;

import group6.ecommerce.configuration.VnpayConfig;
import group6.ecommerce.model.Company;
import group6.ecommerce.model.Users;
import group6.ecommerce.payload.request.companyRequest;
import group6.ecommerce.payload.response.CompanyRespone;
import group6.ecommerce.payload.response.HttpResponse;
import group6.ecommerce.service.UserService;
import group6.ecommerce.service.companyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequiredArgsConstructor
@Transactional
public class CompanyController {
    private final UserService userService;
    private final companyService companyService;
    @GetMapping ("myconpanys")
    public HttpResponse selectMyCompany (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        List<CompanyRespone> listComany = new ArrayList<>();
        userLogin.getCompanyList().stream().forEach(item -> {
            listComany.add(new CompanyRespone(item));
        });
        HttpResponse respone = new HttpResponse(HttpStatus.OK.value(),"Thành Công",listComany);
        return respone;
    }

    @GetMapping ("mycompanys/{id}")
    public HttpResponse selectMyCompany (@PathVariable ("id")int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        AtomicReference<Company> company = new AtomicReference<>(new Company());
        userLogin.getCompanyList().stream().forEach(item ->{
            if (item.getCompanyId() == id){
                company.set(item);
            }
        });
        CompanyRespone companyRespone = new CompanyRespone(company.get());
        HttpResponse respone = new HttpResponse(HttpStatus.OK.value(),"Thành Công",companyRespone);
        return respone;
    }

    @PostMapping ("company/add")
    public ResponseEntity<HttpResponse> addCompany (@RequestBody companyRequest companyRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users principal = (Users) authentication.getPrincipal();
        Users userLogin = userService.findById(principal.getId());
        companyRequest.setUser(userLogin);
        Company company = companyRequest.getcomCompany();
        company.setCompanyId(Integer.parseInt(VnpayConfig.getRandomNumber(7)));
        companyService.addCompany(company);
        HttpResponse respone = new HttpResponse(HttpStatus.OK.value(), "Thêm Thành Công",company);
        return ResponseEntity.ok(respone);
    }
}
