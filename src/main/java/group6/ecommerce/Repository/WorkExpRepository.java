package group6.ecommerce.Repository;

import group6.ecommerce.model.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExpRepository extends JpaRepository<WorkExp, Integer> {
}
