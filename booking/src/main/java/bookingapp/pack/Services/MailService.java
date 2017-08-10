package bookingapp.pack.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


@Service("gtEmail")
public class MailService {

        @Autowired
        private MailSender emailSender;

        public void sendSimpleMessage(
                String to, String subject, String text) {


            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("gtbookingapp@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);

        }
    }




