package com.stackroute.EmailApp.service;

import com.stackroute.EmailApp.model.EmailData;

public interface emailService {
    public abstract String sendEmail(EmailData emailData);
}
