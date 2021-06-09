package springbootvisitormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootvisitormanagementsystem.model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long>{

}
