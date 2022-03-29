package com.esprit.pidevbackend.Repository;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import com.esprit.pidevbackend.Domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;





@Repository
public interface IReservation  extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByStartDateResIsBefore(LocalDateTime date);

	
}
