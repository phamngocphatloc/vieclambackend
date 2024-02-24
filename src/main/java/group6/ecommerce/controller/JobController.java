package group6.ecommerce.controller;

import group6.ecommerce.payload.response.JobRespone;
import group6.ecommerce.payload.response.PaginationResponse;
import group6.ecommerce.service.JobService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("job")
@RequiredArgsConstructor
@Transactional
public class JobController {
    private final JobService jobService;
    @GetMapping ("joblocation")
    public PaginationResponse GetJobByLocation (@RequestParam ("location") String location, @RequestParam ("pagenum") Optional<Integer> pageNum){
        System.out.println(location);
        return jobService.SelectJobByLocation(location,pageNum.orElse(0),7);
    }
    @GetMapping ("jobs")
    public PaginationResponse GetAllJob (@RequestParam (value = "search", defaultValue = "") String search,
                                         @RequestParam ("pagenum") Optional<Integer> pageNum,
                                         @RequestParam (value = "location", defaultValue = "")String location,
                                         @RequestParam (value = "pricebefore", defaultValue = "1")int priceBefore,
                                         @RequestParam (value = "priceafter", defaultValue = "2147483647")int priceAfter,
                                         @RequestParam (value = "fields", defaultValue = "job_id")String fields,
                                         @RequestParam (value = "orderby", defaultValue = "asc")String orderBy,
                                         @RequestParam (value = "nature",defaultValue = "")String nature){
        return jobService.SelectAll(search,location,nature,priceBefore,priceAfter,pageNum.orElse(0),5,fields,orderBy);
    }

    @GetMapping (value = "/{id}")
    public JobRespone selectById (@PathVariable int id){
        return new JobRespone(jobService.SelectById(id));
    }

    @GetMapping (value = "company/{id}")
    public List<JobRespone> selectByCompanyId (@PathVariable int id){
        List<JobRespone> jobs = jobService.SelectJobByCompany(id);
        return jobs;
    }
}
