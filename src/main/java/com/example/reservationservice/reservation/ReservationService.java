package com.example.reservationservice.reservation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.reservation.dto.ReservationDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public Integer healthCheck() {
        return reservationRepository.healthCheck();
    }

    public Reservation getReservation(Integer id) {
        return reservationRepository.findById(id, Reservation.class);
    }

    public void createNewReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();

        // TODO: check business listing vacancy

        // TODO: maybe check if already made reservation today, but maybe can allow more than 1 reservation per day too

        reservation.setBusinessListingDiscountsId(reservationDTO.getBusinessListingDiscountsId());
        reservation.setDate(reservationDTO.getDate());
        reservation.setNoOfDiners(reservationDTO.getNoOfDiners());
        reservation.setSpecialRequests(reservationDTO.getSpecialRequests());
        reservation.setCreatedDate(LocalDateTime.now());
        reservation.setUpdatedDate(LocalDateTime.now());
        reservation.setCreatedBy(reservationDTO.getCreatedBy());

        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error occurred in creating reservation.");
        }
    }

    public void editReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(reservationDTO.getId(), Reservation.class);

        reservation.setBusinessListingDiscountsId(reservationDTO.getBusinessListingDiscountsId());
        reservation.setDate(reservationDTO.getDate());
        reservation.setNoOfDiners(reservationDTO.getNoOfDiners());
        reservation.setSpecialRequests(reservationDTO.getSpecialRequests());
        reservation.setUpdatedDate(LocalDateTime.now());

        try {
            reservationRepository.save(reservation);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error occurred in updating reservation.");
        }
    }

    public List<Reservation> getUpcomingReservations(Integer userId) {
        return reservationRepository.getUpcomingReservations(userId);
    }

    public List<Reservation> getHistoricalReservations(Integer userId) {
        return reservationRepository.getHistoricalReservations(userId);
    }  
    
    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id, Reservation.class);
    }

}
