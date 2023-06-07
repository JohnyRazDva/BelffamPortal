package com.bellfam.website.controller.mvc.content.documents;

import com.bellfam.website.model.Link;
import com.bellfam.website.service.interf.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/private/documents")
public class ContentDocumentsController {

    @Autowired
    private LinkService linkService;

    @RequestMapping()
    public String documentsContent(@ModelAttribute("link") Link link, Model model) {
        model.addAttribute("presentation", "documents");
        model.addAttribute("documentsPresentation", "view");
        model.addAttribute("links", linkService.findAll());
        return "/home";
    }

    @RequestMapping("/edit")
    public String editDocumentsContent(@ModelAttribute("link") Link link, Model model) {
        model.addAttribute("link", link);
        model.addAttribute("presentation", "documents");
        model.addAttribute("documentsPresentation", "edit");
        return "/home";
    }

    @PostMapping("/add")
    public String addLinkDocumentsContent(@ModelAttribute("link") Link link , Model model) {

        linkService.create(link);
        model.addAttribute("presentation", "documents");
        model.addAttribute("links", linkService.findAll());
        return "redirect:/private/documents";
    }
}
