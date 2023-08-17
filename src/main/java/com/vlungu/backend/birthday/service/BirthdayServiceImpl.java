package com.vlungu.backend.birthday.service;

import com.vlungu.backend.birthday.dao.BirthdayRepository;
import com.vlungu.backend.birthday.entity.Birthday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthdayServiceImpl implements BirthdayService{
    private BirthdayRepository birthdayRepository;

    @Autowired
    public BirthdayServiceImpl(BirthdayRepository theRestaurantRepository) {birthdayRepository = theRestaurantRepository;}

    @Override
    public List<Birthday> findAll() {
        return birthdayRepository.findAll();
    }

    @Override
    public Birthday findById(int theId) {
        return null;
    }

    @Override
    public void save(Birthday theBirthday) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
