package com.bellfam.website.controller.mvc.content.mail;

import com.bellfam.website.service.interf.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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
    EmailService emailService;

    @RequestMapping
    public String showMailPage(Model model) {
        model.addAttribute("presentation", "mail");
        return "/home";
    }

    @PostMapping("/send")
    public String sendMail(@RequestParam(name = "to") String to, @RequestParam(name = "companyName") String companyName,
                           @RequestParam(name = "companyMainAddress") String companyMainAddress,
                           @RequestParam(name = "companySecondAddress") String companySecondAddress,
                           @RequestParam(name = "driverInfo") String driverInfo,
                           @RequestParam(name = "date") String date) throws MessagingException, IOException {
        emailService.sendMalfunctionLetter(to, companyName, companyMainAddress, companySecondAddress, driverInfo, date);
        return "redirect:/private/mail";
    }
}
