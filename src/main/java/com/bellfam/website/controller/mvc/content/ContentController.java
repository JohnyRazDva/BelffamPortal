package com.bellfam.website.controller.mvc.content;

import com.bellfam.website.model.VideoLink;
import com.bellfam.website.service.interf.link.VideoLinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/content")
public class ContentController  {

    @Autowired
    private VideoLinkService videoLinkService;

    @RequestMapping("/default")
    public String defaultContent(Model model, @ModelAttribute("videoLink") VideoLink videoLink) {
        model.addAttribute("videoLinks", videoLinkService.findAll());
        model.addAttribute("presentation", "default");
        return "/home";
    }

    @PostMapping("/default/private/edit-video-link")
    public String editVideoLink(@RequestParam("id") int id, @RequestParam("linkValue") String linkValue,
                                @RequestParam("description") String description) {
        videoLinkService.updateVideoLink(id, linkValue, description);
        return "redirect:/content/default";
    }

    @GetMapping("/default/private/delete")
    public String deleteVideoLink(@RequestParam("id") int id) {
        videoLinkService.delete(videoLinkService.findById(id));
        return "redirect:/content/default";
    }

    @PostMapping("/default/private/add")
    public String addVideoLink(Model model, @ModelAttribute("videoLink") @Valid VideoLink videoLink, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            videoLinkService.create(videoLink);
        }
        model.addAttribute("videoLinks", videoLinkService.findAll());
        model.addAttribute("presentation", "default");
        return "/home";
    }
}
