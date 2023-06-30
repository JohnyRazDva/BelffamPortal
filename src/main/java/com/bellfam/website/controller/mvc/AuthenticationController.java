package com.bellfam.website.controller.mvc;

import com.bellfam.website.model.User;
import com.bellfam.website.service.impl.user.UserDetailsServiceImpl;
import com.bellfam.website.service.interf.user.UserService;
import com.bellfam.website.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("presentation", "default");
        return "/home";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("presentation","registration");
        return "/home";
    }

    @PostMapping("/process-registration")
    public String processRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("presentation","registration");
            return "/home";
        }
        userService.create(user);
        return "redirect:/home";
    }
}
