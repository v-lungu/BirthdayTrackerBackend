package com.vlungu.backend.birthday.notification;

public interface EmailService {
    void sendSimpleMessage(String from, String to, String subject, String text);
}
