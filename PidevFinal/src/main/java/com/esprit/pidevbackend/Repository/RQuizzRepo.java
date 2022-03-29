package com.esprit.pidevbackend.Repository;
import com.esprit.pidevbackend.Domain.RQuizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RQuizzRepo extends JpaRepository<RQuizz,Long> {

    @Query("select u from RQuizz u where u.qvt.id=:id")
    RQuizz SelectRquizz(@Param("id") Long id);

}
