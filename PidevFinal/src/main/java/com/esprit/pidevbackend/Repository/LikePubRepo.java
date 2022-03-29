package com.esprit.pidevbackend.Repository;

import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.LikePub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikePubRepo extends JpaRepository<LikePub,Long> {

    @Query("select a.enumLike from LikePub a join a.publications p where p.id=:id  ")
    public List<EnumLike> getAllLikeByPub(@Param("id") Long idPub);
//Like li aamlinhoum jma3a aal pubs mta3in user
    @Query("select a.enumLike from LikePub a join a.publications p where p.user.id=:idUser  ")
    public List<EnumLike> getAllLikeByPubByUser(@Param("idUser") Long idUser);

    @Query("select a.enumLike from LikePub a join a.users p where p.id=:id  ")
    public List<EnumLike> getAllLikeByUser(@Param("id") Long idUserb);

    @Query("select count(p.id) from LikePub a join a.publications p where p.id=:id")
    public int countAllLikeByPub(@Param("id") Long idPub);
}
