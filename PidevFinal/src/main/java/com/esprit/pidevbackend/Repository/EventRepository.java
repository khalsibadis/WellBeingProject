package com.esprit.pidevbackend.Repository;


import com.esprit.pidevbackend.Domain.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select u from User u where u.departement=:dep")
    List<User> afficherListUserByDepartment(@Param("dep") Departement dep);

    @Query("select u from User u where u.office=:office")
    public List<User> afficherListUserByOffice(@Param("office") Office office);

    @Query("select u from User u join u.events v where v.id=:id and u.departement=:dep ")
    public List<User> afficherParticipantByDepartement(@Param("id") Long idEvent, @Param("dep") Departement departement);

    @Query("select u from Event u where  u.date =:date ")
        //SELECT *  FROM `event` WHERE  date(date) = DATE_ADD(CURRENT_DATE,INTERVAL 1 DAY)
    List<Event> ListEventBeforeSystemeDate(@Param("date") Date date);

    @Query(value = "SELECT DATE_ADD(CURRENT_DATE,INTERVAL 1 DAY)", nativeQuery = true)
    public Date dateTomorrow();


    @Query("select u from User u join u.events v where v.date<current_date ")
    List<User> ListParticipantBeforeSystemDate();




    @Query("select u from User u join u.events v where v.id=:id")
    List<User> ListParticipantEvent(@Param("id") Long idEvent);



    @Query("select u.email from User u join u.events v where v.id=:id ")
    public List<String> ListUserByEvent(@Param("id") Long idEvent);

    @Query(value = "select * from event  where  date(date) = DATE_ADD(CURRENT_DATE,INTERVAL 1 DAY)", nativeQuery = true)
    List<Event> getEventOneDayBefore();

@Query("select x.email  from User x join x.events v where x.ineterestCenter=:interestCenter ")
List<String> sendEventToUserByInterestCenter(@Param("interestCenter") IneterestCenter ineterestCenter);

    @Query("select a from Event a where a.recommondation=true ")
    List<Event> EventRecommonde();

}
