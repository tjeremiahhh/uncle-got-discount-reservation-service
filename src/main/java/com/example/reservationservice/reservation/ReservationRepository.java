package com.example.reservationservice.reservation;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.reservationservice.common.repository.SimpleJdbcRepositoryImpl;
import com.example.reservationservice.entity.Reservation;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationRepository extends SimpleJdbcRepositoryImpl {
    public Integer healthCheck() {
        return querySingleObject("select id from reservation limit 1", Integer.class);
    }

    public List<Reservation> getUpcomingReservations(Integer userId) {
        StringBuilder sqlQuery = new StringBuilder(
            "select "
            +"    * "
            +"from "
            +"    reservation "
            +"where "
            +"    created_by = :userId "
            +"    and date >= now() "
        );

        MapSqlParameterSource sqlParameters = new MapSqlParameterSource("userId", userId);

        return queryList(sqlQuery.toString(), sqlParameters, Reservation.class);
    }

    public List<Reservation> getHistoricalReservations(Integer userId) {
        StringBuilder sqlQuery = new StringBuilder(
            "select "
            +"    * "
            +"from "
            +"    reservation "
            +"where "
            +"    created_by = :userId "
            +"    and date < now() "
        );

        MapSqlParameterSource sqlParameters = new MapSqlParameterSource("userId", userId);

        return queryList(sqlQuery.toString(), sqlParameters, Reservation.class);
    }
}
