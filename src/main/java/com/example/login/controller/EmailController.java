package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @GetMapping("/sendemail")
    public String sendSimpleEmail(@RequestParam String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Register account");
        message.setText("Your account is active, you can login with it");
        this.emailSender.send(message);
        return "Email Sent!";
    }

}
