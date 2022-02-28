package com.WellBeingProject.GetCloser.Repository;

import com.WellBeingProject.GetCloser.Entity.CommentPub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentPubRepository extends JpaRepository <CommentPub,Integer> {
}
