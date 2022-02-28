package com.example.EventManage.repositories;

import com.example.EventManage.entities.Event;
import com.example.EventManage.entities.User;
import com.example.EventManage.enumeration.Departement;
import com.example.EventManage.enumeration.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select u from User u where u.departement=:dep")
    List<User> afficherListUserByDepartment(@Param("dep") Departement dep);

    @Query("select u from User u where u.office=:office")
    public List<User> afficherListUserByOffice(@Param("office") Office office) ;
}
