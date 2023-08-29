package com.vlungu.backend.birthday.notification;

import com.vlungu.backend.birthday.entity.Birthday;
import com.vlungu.backend.birthday.service.BirthdayService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailController {
    private final EmailService emailService;
    private BirthdayService birthdayService;

    @Autowired
    public EmailController(EmailService theEmailService, BirthdayService theBirthdayService) {
        this.emailService = theEmailService;
        this.birthdayService = theBirthdayService;
    }

    @PostConstruct
    public void sendOnStart(){
        List<Birthday> todayBirthdays = birthdayService.findToday();

        if (!todayBirthdays.isEmpty()) {
            String text = "Hello Vlad, \r\n\r\nHere are your birthdays for today: \r\n\r\n";
            for (Birthday bday : todayBirthdays) {
                text += bday.emailFormat() + "\r\n";
            }
            text += "\r\n Wish them a happy birthday! \r\n";

            emailService.sendDailyBirthdays("birthday@tracker.com", "v_lungu@outlook.com", "Birthdays Today", text);
        }
    }
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendOnSchedule(){
        List<Birthday> todayBirthdays = birthdayService.findToday();

        if (!todayBirthdays.isEmpty()) {
            String text = "Hello Vlad, \r\n\r\nHere are your birthdays for today: \r\n\r\n";
            for (Birthday bday : todayBirthdays) {
                text += bday.emailFormat() + "\r\n";
            }
            text += "\r\n Wish them a happy birthday! \r\n";

            emailService.sendDailyBirthdays("birthday@tracker.com", "v_lungu@hotmail.com", "Birthdays Today", text);
        }
    }
}
