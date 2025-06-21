package org.example.emailverifier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${FROM}")
    String from;
    @Autowired
    JavaMailSender sender;

    public void send(String to, String code) throws MailException {
        String text = "Enter this code to verify your account: ";
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom(from);
        message.setSubject("Verify Code");
        message.setText(text+code);

        sender.send(message);
    }
}
