package com.antikryptonite.outsourcing.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.*;



import java.util.Properties;

class EmailSenderTest {

    public static final int PORT = 587;

    @Test
    public void sendTestMessage() {
        EmailSender emailSender = new EmailSender("antikriptonit.noreply@gmail.com");
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(PORT);
        javaMailSender.setUsername("antikriptonit.noreply@gmail.com");
        javaMailSender.setPassword("OeTzYi9U9kXhdOkenQsP");

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        emailSender.setJavaMailSender(javaMailSender);

        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setEmail("egorryazancev1908@mail.ru");
        emailMessage.setSubject("Test message");
        emailMessage.setText("Hello Egor");

        emailSender.send(emailMessage);
    }

    @Autowired
    public void setEmailSender(EmailSender emailSender) {
    }
}