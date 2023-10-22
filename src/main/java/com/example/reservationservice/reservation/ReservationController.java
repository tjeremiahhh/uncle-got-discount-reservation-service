package com.example.reservationservice.reservation;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = { "http://localhost:4200",
        "http://ugd-frontend-app-lb-1592138430.ap-southeast-1.elb.amazonaws.com" })
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/healthcheck")
    public Integer healthCheck() {
        return reservationService.healthCheck();
    }

    @GetMapping("/get-reservation")
    public Reservation getReservation(Integer id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/create-new-reservation")
    public void createNewReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.createNewReservation(reservationDTO);
    }

    @PostMapping("/edit-reservation")
    public void editReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.editReservation(reservationDTO);
    }
}
