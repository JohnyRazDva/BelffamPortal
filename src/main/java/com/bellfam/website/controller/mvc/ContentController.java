package com.bellfam.website.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @RequestMapping("/default")
    public String defaultContent(Model model){
       model.addAttribute("presentation", "default");
       return "/home";
    }
    @RequestMapping("/private/documents")
    public String documentsContent(Model model){
        model.addAttribute("presentation", "documents");
        return "/home";
    }
}
