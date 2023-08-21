package com.vlungu.backend.birthday.dao;

import com.vlungu.backend.birthday.entity.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer> {
    @Query("SELECT e FROM Birthday e WHERE e.birthday=:date")
    List<Birthday> findByDateIs(@Param("date") LocalDate date);

}