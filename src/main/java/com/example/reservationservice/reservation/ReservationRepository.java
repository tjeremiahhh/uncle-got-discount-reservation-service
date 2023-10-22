package com.example.reservationservice.reservation;

import org.springframework.stereotype.Repository;

import com.example.reservationservice.common.repository.SimpleJdbcRepositoryImpl;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationRepository extends SimpleJdbcRepositoryImpl {
    public Integer healthCheck() {
        return querySingleObject("select id from reservation limit 1", Integer.class);
    }
}
