package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;



import tn.esprit.spring.entities.Phase;


@Repository
public interface PhaseRepository  extends JpaRepository<Phase, Long> {
	@Query("Select p FROM Phase p join p.game bs where bs.idg = :idg")
   public List<Phase> findPhaseEntitiesByGameId(@PathVariable("category") Long idg);


	
	

}
