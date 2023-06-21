package com.bellfam.website.controller.mvc.content.news;

import com.bellfam.website.model.Post;
import com.bellfam.website.service.interf.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping("/private/news")
public class NewsController {

    @Autowired
    private PostService postService;

    @RequestMapping
    public String showNews(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("presentation", "news");
        model.addAttribute("posts", postService.findAll());
        return "/home";
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute("post") Post post) {
        postService.createPost(post);
        return "redirect:/private/news";
    }

    @RequestMapping("/delete")
    public String deleteNews(@RequestParam(name = "id") int id) {
        postService.delete(postService.findById(id));
        return "redirect:/private/news";
    }
}
