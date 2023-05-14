package com.bellfam.website.controller.mvc;

import com.bellfam.website.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping(PostController.POST_URL)
public class PostController extends CRUDController<Post, Integer> {

    public static final String POST_URL = "ui/post";
    public static final String POST_NAME = "post";

    @Override
    String getEntityName() {
        return POST_NAME;
    }
}
