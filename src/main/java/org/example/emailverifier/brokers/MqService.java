package org.example.emailverifier.brokers;

import org.example.emailverifier.logging.Loggable;
import org.example.emailverifier.logging.LoggableException;
import org.example.emailverifier.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqService {
    @Autowired
    EmailService emailService;

    // TODO receiver
    @Loggable
    @LoggableException
    @RabbitListener(queues = "email-queue")
    public void sendMail(MqDto data){
        // Fetching data from dto
        String to = data.getTo();
        String secretCode = data.getSecretCode();

        emailService.send(to,secretCode);
    }

    @RabbitListener(queues = "email-queue-v2")
    public void sendMail(MetaInfoDto metaInfoDto){
        emailService.send(metaInfoDto.getTo(), metaInfoDto.getSecretCode(), metaInfoDto.getProjectName(), metaInfoDto.getSenderUsername(), metaInfoDto.getSenderIp());
    }
}
