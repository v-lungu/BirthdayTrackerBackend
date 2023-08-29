package com.vlungu.backend.birthday.notification;

import com.vlungu.backend.birthday.entity.Birthday;
import com.vlungu.backend.birthday.service.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender emailSender;
    private BirthdayService birthdayService;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.emailSender = javaMailSender;
    }

    @Override
    public void sendDailyBirthdays(
            String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
