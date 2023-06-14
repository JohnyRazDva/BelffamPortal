package com.bellfam.website.controller.mvc.content.documents;

import com.bellfam.website.model.Link;
import com.bellfam.website.service.interf.EmailService;
import com.bellfam.website.service.interf.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/private/documents")
public class ContentDocumentsController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private EmailService emailService;

    @RequestMapping()
    public String documentsContent(@ModelAttribute("link") Link link, Model model) throws MessagingException {
        model.addAttribute("presentation", "documents");
        model.addAttribute("documentsPresentation", "view");
        model.addAttribute("links", linkService.findAll());
        return "/home";
    }

    @PostMapping("/update/{id}")
    public String editDocumentsContent(@PathVariable String id, @RequestParam(name = "linkValue") String linkValue, @RequestParam(name = "description") String description ) {
        linkService.updateLink(id,linkValue,description);
        return "redirect:/private/documents";
    }

    @GetMapping("/delete/{id}")
    public String deleteDocumentsContent(@PathVariable String id){
        linkService.deleteLink(id);
        return "redirect:/private/documents";
    }

    @PostMapping("/add")
    public String addLinkDocumentsContent(@ModelAttribute("link") Link link , Model model) {
        linkService.create(link);
        model.addAttribute("presentation", "documents");
        model.addAttribute("links", linkService.findAll());
        return "redirect:/private/documents";
    }
}
