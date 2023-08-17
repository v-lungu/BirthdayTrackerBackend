package com.vlungu.backend.birthday.controller;

import com.vlungu.backend.birthday.entity.Birthday;
import com.vlungu.backend.birthday.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/birthday")
public class BirthdayController {
    private BirthdayService birthdayService;

    @Autowired
    public BirthdayController(BirthdayService theRestaurantService) {
        birthdayService = theRestaurantService;
    }

    @GetMapping("/list")
    public List<Birthday> listRestaurants(Model theModel) {
        return birthdayService.findAll();
    }
}
