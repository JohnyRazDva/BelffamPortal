package com.bellfam.website.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/accessDeniedPage")
public class AccessDeniedController {

    @GetMapping()
    public String accessDenied(){
        return "/accessDeniedPage";
    }
}
