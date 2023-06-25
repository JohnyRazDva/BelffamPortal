package com.bellfam.website.controller.mvc.content.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @RequestMapping
    public String showContacts(Model model){
        model.addAttribute("presentation", "contacts");
        return "/home";
    }
}
