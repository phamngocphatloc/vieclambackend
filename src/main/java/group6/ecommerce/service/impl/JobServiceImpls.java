package group6.ecommerce.service.impl;

import group6.ecommerce.Repository.JobRepository;
import group6.ecommerce.model.Job;
import group6.ecommerce.payload.response.JobRespone;
import group6.ecommerce.payload.response.PaginationResponse;
import group6.ecommerce.service.JobService;
import group6.ecommerce.utils.HandleSort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobServiceImpls implements JobService {
    private final JobRepository jobRepository;
    @Override
    public PaginationResponse SelectJobByLocation(String location, int pageNum, int pageSize) {
        Sort sort = HandleSort.buildSortProperties("date","desc");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<Job> pageJob = jobRepository.findByLocationLike(location,pageable);
        List<JobRespone> listJobPage = new ArrayList<>();
        pageJob.getContent().stream().forEach(item -> {
            listJobPage.add(new JobRespone(item));
        });
        return new PaginationResponse(pageNum,pageSize,pageJob.getTotalElements(),pageJob.isLast(),pageJob.getTotalPages(),listJobPage);
    }

    @Override
    public PaginationResponse SelectAll(String search, String location, String nature, int before, int after, int pageNum, int pageSize, String feild, String orderBy) {
        Sort sort = HandleSort.buildSortProperties(feild, orderBy);
        Pageable pageable = PageRequest.of(pageNum,pageSize,sort);
        Page<Job> jobs = jobRepository.findFillter(search,location,nature,before,after, pageable);
        List<JobRespone> listJobPage = new ArrayList<>();
        jobs.getContent().stream().forEach(item -> {
            listJobPage.add(new JobRespone(item));
        });
        return new PaginationResponse(pageNum,pageSize,jobs.getTotalElements(),jobs.isLast(),jobs.getTotalPages(),listJobPage);
    }

    @Override
    public Job SelectById(int id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public List<JobRespone> SelectJobByCompany(int companyId) {
        List<Job> jobs = jobRepository.selectJobByCompany(companyId);
        List<JobRespone> listJob = new ArrayList<>();
        jobs.stream().forEach(item -> {
            listJob.add(new JobRespone(item));
        });
        return listJob;
    }

    @Override
    public void save(Job job) {
        jobRepository.save(job);
    }


}
