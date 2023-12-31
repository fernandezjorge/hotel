package com.jorgefernandez.hotel.repositories;

import com.jorgefernandez.hotel.models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}