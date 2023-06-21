package com.bellfam.website.service.interf;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import java.io.IOException;

/**
 * @author Eugene Petrov
 */
public interface EmailService {
    void send(String to, String subject, String text);

    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;

    void sendMalfunctionLetter(String to, String companyName, String companyMainAddress, String companySecondAddress, String driverInfo, String date) throws MessagingException, IOException;
}
