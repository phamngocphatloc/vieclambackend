package group6.ecommerce.service;

import group6.ecommerce.model.Job;
import group6.ecommerce.payload.response.JobRespone;
import group6.ecommerce.payload.response.PaginationResponse;

import java.util.List;

public interface JobService {
    public PaginationResponse SelectJobByLocation (String location, int pagenum, int pageSize);

    public PaginationResponse SelectAll (String search,
                                         String location,String nature,
                                         int before,
                                         int after,
                                         int pagenum,
                                         int pageSize,
                                         String feild,
                                         String orderBy);
    public Job SelectById (int id);
    public List<JobRespone> SelectJobByCompany (int companyId);
    public void save (Job job);
}
