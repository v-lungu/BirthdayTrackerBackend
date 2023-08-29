package com.vlungu.backend.birthday.notification;

public interface EmailService {
    void sendDailyBirthdays(String from, String to, String subject, String text);
}
