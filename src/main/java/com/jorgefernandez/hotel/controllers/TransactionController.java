package com.jorgefernandez.hotel.controllers;

import com.jorgefernandez.hotel.models.Reservation;
import com.jorgefernandez.hotel.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/hotel")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/reservation", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody @Valid Reservation reservation) {
        return transactionService.createReservation(reservation);
    }

    @GetMapping(value = "/reservation/{id}", produces = APPLICATION_JSON_VALUE)
    public Reservation retrieveReservation(@PathVariable Long id) {
        return transactionService.retrieveReservationById(id);
    }

    @DeleteMapping("/reservation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservation(@PathVariable Long id) {
        transactionService.deleteReservationById(id);
    }
}
