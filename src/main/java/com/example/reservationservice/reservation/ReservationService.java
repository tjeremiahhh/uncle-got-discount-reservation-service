package com.example.reservationservice.reservation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.reservationservice.entity.Reservation;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;


    public void createNewReservation() {

    }

    public Reservation getReservation(Integer id) {
        return reservationRepository.findById(id, Reservation.class);
    }
}
