package com.example.reservationservice.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.reservation.dto.ReservationDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/getReservation")
    public Reservation getReservation(Integer id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/createNewReservation")
    public void createNewReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.createNewReservation(reservationDTO);
    }

    @PostMapping("/editReservation")
    public void editReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.editReservation(reservationDTO);
    }
}
