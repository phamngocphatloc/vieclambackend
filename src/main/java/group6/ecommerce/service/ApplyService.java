package group6.ecommerce.service;

import group6.ecommerce.model.Apply;
import group6.ecommerce.model.Job;
import group6.ecommerce.model.Users;
import org.apache.catalina.User;

import java.util.List;

public interface ApplyService {
    public void save (Apply apply);

    public boolean checkApply (Users user, Job job);

    public List<Apply> selectApplysByUser (Users user);

    public Apply selectById (int id);
    public void delebeAplly (Apply apply);
}
