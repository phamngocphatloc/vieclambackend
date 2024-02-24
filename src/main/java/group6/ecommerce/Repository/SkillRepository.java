package group6.ecommerce.Repository;

import group6.ecommerce.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {
    public Skill findBySkillNameLike (String name);
}
