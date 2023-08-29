package com.vlungu.backend.birthday.service;

import com.vlungu.backend.birthday.entity.Birthday;

import java.time.LocalDate;
import java.util.List;

public interface BirthdayService {
    List<Birthday> findAll();

    Birthday findById(int theId);

    Birthday save(Birthday theBirthday);

    void deleteById(int theId);

    List<Birthday> findByDateIs(LocalDate date);

    List<Birthday> findToday();
}
