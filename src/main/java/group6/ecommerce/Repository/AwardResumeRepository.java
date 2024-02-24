package group6.ecommerce.Repository;

import group6.ecommerce.model.AwardsResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardResumeRepository extends JpaRepository<AwardsResume,Integer> {
}
