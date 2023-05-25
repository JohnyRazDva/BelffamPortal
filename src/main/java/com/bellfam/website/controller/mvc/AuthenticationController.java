package com.bellfam.website.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }
}
