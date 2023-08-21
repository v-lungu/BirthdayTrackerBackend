package com.vlungu.backend.birthday.service;

import com.vlungu.backend.birthday.dao.BirthdayRepository;
import com.vlungu.backend.birthday.entity.Birthday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<Birthday> ret = birthdayRepository.findById(theId);

        if (ret.isPresent()) {
            return ret.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
    }

    @Override
    public Birthday save(Birthday theBirthday) {
        return birthdayRepository.save(theBirthday);
    }

    @Override
    public void deleteById(int theId) {
        birthdayRepository.deleteById(theId);
    }

    @Override
    public List<Birthday> findByDateIs(LocalDate date) {
        return birthdayRepository.findByDateIs(date);

    }
}
