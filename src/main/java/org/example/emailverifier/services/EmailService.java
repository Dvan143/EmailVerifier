package org.example.emailverifier.services;

import org.example.emailverifier.logging.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger log = LoggerFactory.getLogger(EmailService.class);

    @Loggable
    public void send(String to, String code){
        String text = "Secret code from SocialMedia: ";
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom(from);
        message.setSubject("SocialMedia's Secret Code");
        message.setText(text+code);

        try{
            sender.send(message);
        } catch (MailException ex) {
            log.error("User entered email that does not exist.");
        }
    }
    @Loggable
    public void send(String to, String code, String projectName, String senderUsername) throws MailException {
        // Generating text with fetched data
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ").append(senderUsername)
                .append("! Secret code from ").append(projectName)
                .append(": ").append(code)
                .append("");

        String text = sb.toString();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(projectName + "'s Secret Code");
        message.setText(text);

        try{
            sender.send(message);
        } catch (MailException ex) {
            log.error("User {} entered email {} that does not exist.", senderUsername, to);
        }
    }
}
