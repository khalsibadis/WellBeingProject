package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.QVT;
import com.esprit.pidevbackend.Domain.TypeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QVTRepsitory extends JpaRepository<QVT,Long> {
    @Query(nativeQuery = true,value = "select a.answers_id from answer_users a")
    List<Long> ListIdAnswerAffecteToUser();
@Query("select a.typeAnswer from QVT u join u.questions q join q.answers a where u.id=:id and a.id=:ida ")
    List<TypeAnswer> ListeAnswersQuizz(@Param("id") Long idQuizz,@Param("ida") Long a);
@Query("select q.rQuizzes.id from QVT q where q.id=:id")
Long selectIdResponse(@Param("id") Long idQuizz);
}