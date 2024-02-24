package group6.ecommerce.Repository;

import group6.ecommerce.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query (value = "SELECT * from job where Location like %?1% and is_recruiting = 1",nativeQuery = true)
    Page<Job> findByLocationLike (String location , Pageable page);

    @Query (value = "SELECT * from job where is_recruiting = 1",nativeQuery = true)
    Page<Job> findAllReduriting (Pageable page);

    @Query (value = "select * from job  where (job_name like %?1% or ?1 = '') and (location like %?2% or ?2 = '')\n" +
            "and (nature like %?3% or ?3 = '') and (price_before between ?4 and ?5) and is_recruiting = 1", nativeQuery = true)
    Page<Job> findFillter (String search, String location, String nature, int priceBefore, int priceAfter, Pageable page);

    @Query (value = "select * from job where company_id = ?1", nativeQuery = true)
    List<Job> selectJobByCompany (int companyId);
}
