package com.esprit.pidevbackend.Repository;


import com.esprit.pidevbackend.Domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
    @Query("select a from Answer a where a.question.id=:id")
    public List<Answer> findAllAnswerForQuestion(@Param("id") Long idQue);
    @Query("select a from Answer a join a.users u where u.id=:id ")
    public List<Answer> findAllAnswerByUser(@Param("id") Long idUser);
    }
