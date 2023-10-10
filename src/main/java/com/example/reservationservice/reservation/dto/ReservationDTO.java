package com.example.reservationservice.reservation.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservationDTO {
    private Integer id;
    private Integer businessListingDiscountsId;
    private Integer noOfDiners;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private String specialRequests;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Integer createdBy;
}
