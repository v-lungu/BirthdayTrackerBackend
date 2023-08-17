package com.vlungu.backend.birthday.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlungu.backend.birthday.entity.Birthday;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer> {
    // that's it

}