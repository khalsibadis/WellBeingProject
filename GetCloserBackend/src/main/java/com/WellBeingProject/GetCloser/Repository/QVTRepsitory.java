package com.WellBeingProject.GetCloser.Repository;

import com.WellBeingProject.GetCloser.Entity.QVT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QVTRepsitory extends JpaRepository<QVT,Integer> {
}
