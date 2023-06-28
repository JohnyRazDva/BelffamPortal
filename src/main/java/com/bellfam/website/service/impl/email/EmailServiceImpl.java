package com.bellfam.website.service.impl.email;

import com.bellfam.website.service.interf.EmailService;
import com.bellfam.website.service.pdf.PdfFileRedactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

/**
 * @author Eugene Petrov
 */
@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PdfFileRedactor pdfFileRedactor;

    @Override
    public void send(String to, String subject, String text) throws MailException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("petrovyauhen@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("petrovyauhen@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Malfunction Letter", file);
        javaMailSender.send(message);
    }

    @Override
    public void sendMalfunctionLetter(String to, String companyName, String companyMainAddress, String companySecondAddress, String driverInfo, String date) throws MailException, IOException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("petrovyauhen@gmail.com");
        helper.setTo(to);
        helper.setSubject("Malfunction Letter");
        helper.setText("Malfunction Letter");
        String fileSource = pdfFileRedactor.getResultFileSource(companyName, companyMainAddress, companySecondAddress, driverInfo, date);
        FileSystemResource file = new FileSystemResource(new File(fileSource));
        helper.addAttachment("Malfunction Letter.pdf", file);
        javaMailSender.send(message);
        pdfFileRedactor.deletePdfFile();
    }
}
