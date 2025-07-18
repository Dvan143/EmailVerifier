package org.example.emailverifier.brokers;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
    @Bean
    Queue queue(){
        return new Queue("email-queue", false);
    }

    @Bean
    Exchange exchange(){
        return new DirectExchange("email-exchange");
    }

    @Bean
    Binding binder(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("to.emailService").noargs();
    }

    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
