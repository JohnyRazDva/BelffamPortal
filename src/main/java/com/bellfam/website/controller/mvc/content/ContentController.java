package com.bellfam.website.controller.mvc.content;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.Role;
import com.bellfam.website.model.User;
import com.bellfam.website.service.interf.link.LinkService;
import com.bellfam.website.service.interf.link.VideoLinkService;
import com.bellfam.website.service.interf.role.RoleService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Encoder;
import java.util.List;
import java.util.Optional;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private VideoLinkService videoLinkService;

    @RequestMapping("/default")
    public String defaultContent(Model model) {
        model.addAttribute("videoLink", videoLinkService.get());
        model.addAttribute("presentation", "default");
        return "/home";
    }

    @PostMapping("/default/edit-video-link")
    public String editVideoLink(@RequestParam(name = "videoLink") String link, @RequestParam(name = "description") String description) {
        videoLinkService.updateVideoLink(link, description);
        return "redirect:/content/default";
    }
}
