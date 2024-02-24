package group6.ecommerce.Repository;

import group6.ecommerce.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply,Integer> {
    @Query (value = "select * from apply where user_id = ?1 and  job_id = ?2",nativeQuery = true)
    public Apply findApplyByUser (int userId,int jobid);
    @Query (value = "select * from apply where user_id = ?1",nativeQuery = true)
    public List<Apply> findAllAplyByUser (int userId);
}
