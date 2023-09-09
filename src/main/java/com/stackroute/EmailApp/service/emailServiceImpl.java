package com.stackroute.EmailApp.service;

import com.stackroute.EmailApp.model.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailServiceImpl implements emailService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendEmail(EmailData emailData) {
        System.out.println(emailData);
        //implementing sending mail logic
        try {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            //Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailData.getReceiver());
            mailMessage.setText(emailData.getMailBody());
            mailMessage.setSubject(emailData.getSubject());
            javaMailSender.send(mailMessage);
            // // Sending the mail
            return "Mail Send To " + emailData.getReceiver();
        }
        // Catch block to handle the exceptions
        catch (Exception e){
            e.printStackTrace();
            return "Error while Sending Mail";
        }

    }
}
