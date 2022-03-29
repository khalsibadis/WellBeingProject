package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query("select a from Question a where a.qvt.id=:idqvt ")
    public List<Question> findAllQuestionByQVT(@Param("idqvt") Long idQVT);
}
