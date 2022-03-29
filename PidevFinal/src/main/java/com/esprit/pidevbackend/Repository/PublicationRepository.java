package com.esprit.pidevbackend.Repository;


import com.esprit.pidevbackend.Domain.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    @Query("select count(a.id) from Publication  a where a.user.id=:idU")
    public int countAllPublicationByUser(@Param("idU") Long idUser);
    @Query("select a.id from Publication  a where a.user.id=:idU")
    public List<Publication> GetAllPubByUser(@Param("idU") Long idUser);

}
