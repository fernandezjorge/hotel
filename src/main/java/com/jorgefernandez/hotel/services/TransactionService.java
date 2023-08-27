package com.jorgefernandez.hotel.services;

import com.jorgefernandez.hotel.models.Reservation;
import com.jorgefernandez.hotel.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.lang.String.format;

@Service
public class TransactionService {

    private final ReservationRepository reservationRepository;

    public TransactionService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation retrieveReservationById(final Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.orElseThrow(() ->
                new NoSuchElementException(format("La reserva con id: %s no se encuentra", id)));
    }

    public Reservation createReservation(final Reservation reservation) {
        final Reservation createdReservation = Reservation.builder()
                .mainGuest(reservation.getMainGuest())
                .status(reservation.getStatus())
                .build();
        return reservationRepository.save(createdReservation);
    }

    public void deleteReservationById(final Long id) {
        retrieveReservationById(id);
        reservationRepository.deleteById(id);
    }
}
