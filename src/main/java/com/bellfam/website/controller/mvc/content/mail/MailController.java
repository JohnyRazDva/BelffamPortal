package com.bellfam.website.controller.mvc.content.mail;

import com.bellfam.website.service.interf.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/private/mail")
public class MailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping
    public String showMailPage(Model model) {
        model.addAttribute("presentation", "mail");
        return "/home";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam("to") String to,
                           @RequestParam("companyName") String companyName,
                           @RequestParam("companyMainAddress") String companyMainAddress,
                           @RequestParam("companySecondAddress") String companySecondAddress,
                           @RequestParam("driverInfo") String driverInfo,
                           @RequestParam("date") String date, Model model) {

        model.addAttribute("presentation", "mail");
        try {
            emailService.sendMalfunctionLetter(to, companyName, companyMainAddress, companySecondAddress, driverInfo, date);
            model.addAttribute("error", "email has been send");
        } catch (MailException | MessagingException | IOException e) {
            model.addAttribute("error", "check entered email pls and try again");
            return "/home";
        }
        return "/home";
    }
}
