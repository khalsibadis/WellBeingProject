package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Collaboration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICollaboration extends JpaRepository<Collaboration, Long> {

}
