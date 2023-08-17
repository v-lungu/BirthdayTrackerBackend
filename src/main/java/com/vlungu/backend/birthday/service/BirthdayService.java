package com.vlungu.backend.birthday.service;

import com.vlungu.backend.birthday.entity.Birthday;

import java.util.List;

public interface BirthdayService {
    List<Birthday> findAll();

    Birthday findById(int theId);

    void save(Birthday theBirthday);

    void deleteById(int theId);
}
