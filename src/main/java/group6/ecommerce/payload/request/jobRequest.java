package group6.ecommerce.payload.request;

import group6.ecommerce.model.*;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
@Setter
public class jobRequest {
    private String jobName;
    private String img;
    private int priceBefore;
    private int priceAfter;
    private String Location;
    private Date dateJob;
    private String type;
    private String nature;
    private int vacancy;
    private String description;
    private boolean isRecruiting;
    private int jobCompanyId;
    private Job getJob (){
        Job job = new Job();
        job.setDateJob(dateJob);
        job.setJobName(jobName);
        job.setImg(img);
        job.setPriceAfter(priceAfter);
        job.setPriceBefore(priceBefore);
        job.setLocation(Location);
        job.setType(type);
        job.setNature(nature);
        job.setVacancy(vacancy);
        job.setRecruiting(true);
        job.setDescription(description);
        return job;
    }
}
