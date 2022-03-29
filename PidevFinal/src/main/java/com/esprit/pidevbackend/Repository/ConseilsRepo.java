package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.ConseilsUser;
import com.esprit.pidevbackend.Domain.TypeAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConseilsRepo extends JpaRepository<ConseilsUser,Long> {
    @Query("select a.typeAnswer from QVT qvt join qvt.questions q join q.answers a join a.users u where u.id=:id and u.id=:idU")
    List<TypeAnswer> ListeAnswersQuizzParUser(@Param("id") Long idQuizz, @Param("idU") Long idUser);

    @Query("select a from ConseilsUser a where a.user.id=:id")
    public ConseilsUser FindConseilByUser(@Param("id") Long idUser);
}
