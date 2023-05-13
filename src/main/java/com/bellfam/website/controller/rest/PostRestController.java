package com.bellfam.website.controller.rest;

import com.bellfam.website.model.Post;
import com.bellfam.website.service.interf.CRUDService;
import com.bellfam.website.service.interf.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eugene Petrov
 */
@RestController
@RequestMapping(PostRestController.POST_REST_URL)
public class PostRestController extends CRUDRestController<Post, Integer> {

    public static final String POST_REST_URL = "post";

    @Autowired
    PostService postService;

    @Override
    CRUDService<Post, Integer> getService() {
        return postService;
    }
}
