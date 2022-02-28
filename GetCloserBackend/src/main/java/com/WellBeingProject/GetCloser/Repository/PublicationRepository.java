package com.WellBeingProject.GetCloser.Repository;


import com.WellBeingProject.GetCloser.Entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Integer> {
}
