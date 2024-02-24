package group6.ecommerce.service.impl;

import group6.ecommerce.Repository.ApplyRepository;
import group6.ecommerce.exception.NotFoundException;
import group6.ecommerce.model.Apply;
import group6.ecommerce.model.Job;
import group6.ecommerce.model.Users;
import group6.ecommerce.service.ApplyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpls implements ApplyService {
    private final ApplyRepository applyRepository;
    @Override
    public void save(Apply apply) {
        if (checkApply(apply.getUserApply(),apply.getJobApply())==false) {
            applyRepository.save(apply);
        }else{
            throw new NotFoundException("Bạn Đã Apply Rồi");
        }
    }

    @Override
    public boolean checkApply(Users user, Job job) {
        if (applyRepository.findApplyByUser(user.getId(),job.getJobId())!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Apply> selectApplysByUser(Users user) {
        return applyRepository.findAllAplyByUser(user.getId());
    }

    @Override
    public Apply selectById(int id) {
        return applyRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void delebeAplly(Apply apply) {
        applyRepository.delete(apply);
    }


}
