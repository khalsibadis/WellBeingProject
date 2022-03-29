package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long> {

}
