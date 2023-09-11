package com.vlungu.backend.birthday.service;

import com.vlungu.backend.birthday.dao.BirthdayRepository;
import com.vlungu.backend.birthday.entity.Birthday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
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

    @Override
    public List<Birthday> findToday() {
        LocalDate todayDate = java.time.LocalDate.now();
        todayDate = todayDate.withYear(2000);

        return birthdayRepository.findByDateIs(todayDate);
    }

    @Override
    public List<Birthday> findByUpcoming() {
        LocalDate todayDate = java.time.LocalDate.now();
        todayDate = todayDate.withYear(2000);
        LocalDate upcomingDate = todayDate.plusDays(30);

        if (upcomingDate.getYear() == 2000) {
            return birthdayRepository.findByUpcoming(todayDate, upcomingDate);
        } else {
            upcomingDate = upcomingDate.withYear(2000);
            LocalDate yearEnd = LocalDate.of(2000, Month.DECEMBER, 31);
            LocalDate yearStart = LocalDate.of(2000, Month.JANUARY, 1);

            List<Birthday> birthdaysUpcoming = birthdayRepository.findByUpcomingModifiedA(todayDate, yearEnd);
            List<Birthday> listB = birthdayRepository.findByUpcomingModifiedB(upcomingDate, yearStart);
            birthdaysUpcoming.addAll(listB);

            return birthdaysUpcoming;
        }
    }
}
