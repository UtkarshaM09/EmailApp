package com.stackroute.EmailApp.rabbitmq;

import com.stackroute.EmailApp.model.EmailData;
import com.stackroute.EmailApp.service.emailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {
    @Autowired
    private emailService emailService;

    @RabbitListener(queues = "mail_queue")
    public void getEmailDtoFromQueue(EmailDto emailDto){
        EmailData emailData=new EmailData(emailDto.getReceiver(), emailDto.getSubject(),
                emailDto.getMailBody(), null);
        System.out.println(emailService.sendEmail(emailData));

    }
}
