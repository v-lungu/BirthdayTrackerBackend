package com.vlungu.backend.birthday.controller;

import com.vlungu.backend.birthday.entity.Birthday;
import com.vlungu.backend.birthday.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BirthdayController {
    private BirthdayService birthdayService;

    @Autowired
    public BirthdayController(BirthdayService theBirthdayService) {
        birthdayService = theBirthdayService;
    }

    @GetMapping("/birthdays")
    public List<Birthday> findAll() {
        return birthdayService.findAll();
    }

    @GetMapping("/birthdays/{birthdayId}")
    public Birthday findById(@PathVariable int birthdayId) {
        Birthday theBirthday = birthdayService.findById(birthdayId);
        if (theBirthday == null) {
            throw new RuntimeException("Birthday id not found  - " + birthdayId);
        }
        return theBirthday;
    }

    @PostMapping("/birthdays")
    public Birthday addBirthday(@RequestBody Birthday theBirthday) {
        theBirthday.setId(0);
        return birthdayService.save(theBirthday);
    }

    @PutMapping("/birthdays")
    public Birthday updateEmployee(@RequestBody Birthday theBirthday) {
        return birthdayService.save(theBirthday);
    }

    @DeleteMapping("/birthdays/{birthdayId}")
    public String deleteBirthday(@PathVariable int birthdayId) {
        Birthday tempBirthday = birthdayService.findById(birthdayId);

        if (tempBirthday == null) {
            throw new RuntimeException("There is no birthday with this id - " + birthdayId);
        }

        birthdayService.deleteById(birthdayId);

        return "Deleted employee id - " + birthdayId;
    }

    @GetMapping("birthdays/{date}")
    public List<Birthday> findByDateIs(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return birthdayService.findByDateIs(date);
    }

    @GetMapping("birthdays/today")
    public List<Birthday> findToday() {
        return birthdayService.findToday();
    }

    @GetMapping("birthdays/upcoming")
    public List<Birthday> findByUpcoming() {
        return birthdayService.findByUpcoming();
    }
}
