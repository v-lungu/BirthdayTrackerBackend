package com.vlungu.backend.birthday.dao;

import com.vlungu.backend.birthday.entity.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer> {
    @Query("SELECT e FROM Birthday e WHERE e.birthday=:date ORDER BY e.lastName, e.firstName")
    List<Birthday> findByDateIs(@Param("date") LocalDate date);

    @Query("SELECT e FROM Birthday e WHERE " +
            "e.birthday BETWEEN :dateToday and :dateUpcoming " +
            "ORDER BY e.birthday, e.lastName, e.firstName")
    List<Birthday> findByUpcoming(@Param("dateToday") LocalDate dateToday, @Param("dateUpcoming") LocalDate dateUpcoming);

    @Query("SELECT e FROM Birthday e WHERE " +
            "e.birthday BETWEEN :dateToday AND :yearEnd " +
            "ORDER BY e.birthday, e.lastName, e.firstName")
    List<Birthday> findByUpcomingModifiedA(@Param("dateToday") LocalDate dateToday, @Param("yearEnd") LocalDate yearEnd);

    @Query("SELECT e FROM Birthday e WHERE " +
            "e.birthday BETWEEN :yearStart AND :dateUpcoming " +
            "ORDER BY e.birthday, e.lastName, e.firstName")
    List<Birthday> findByUpcomingModifiedB(@Param("dateUpcoming") LocalDate dateUpcoming, @Param("yearStart") LocalDate yearStart);

}