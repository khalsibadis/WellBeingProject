package com.WellBeingProject.GetCloser.Repository;

import com.WellBeingProject.GetCloser.Entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Integer> {

}
