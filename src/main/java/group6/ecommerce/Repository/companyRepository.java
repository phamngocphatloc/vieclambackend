package group6.ecommerce.Repository;

import group6.ecommerce.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface companyRepository extends JpaRepository<Company,Integer> {
}
