package com.stackroute.EmailApp.controller;

import com.stackroute.EmailApp.model.EmailData;
import com.stackroute.EmailApp.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail-app")
public class emailController {
    @Autowired
    private emailService emailService;

    //http://localhost:8085/mail-app/send-email
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailData emailData){
        return new ResponseEntity<>(emailService.sendEmail(emailData), HttpStatus.OK);
    }

}
