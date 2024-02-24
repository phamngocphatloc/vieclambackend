package group6.ecommerce.Repository;

import group6.ecommerce.model.EducationResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationResumeRepository extends JpaRepository<EducationResume,Integer> {
}
