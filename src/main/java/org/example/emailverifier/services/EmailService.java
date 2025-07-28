package org.example.emailverifier.services;

import org.example.emailverifier.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${MAIL_FROM}")
    String from;
    @Autowired
    JavaMailSender sender;

    @Loggable
    public void send(String to, String code) throws MailException {
        String text = "Secret code from SocialMedia: ";
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom(from);
        message.setSubject("SocialMedia's Secret Code");
        message.setText(text+code);

        sender.send(message);
    }
    @Loggable
    public void send(String to, String code, String projectName, String senderUsername, String senderIp) throws MailException {
        // Generating text with fetched data
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ").append(senderUsername)
                .append("Secret code from ").append(projectName)
                .append(": ").append(code)
                .append("from ip address: ").append(senderIp);

        String text = sb.toString();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(projectName + "'s Secret Code");
        message.setText(text);

        sender.send(message);
    }
}
