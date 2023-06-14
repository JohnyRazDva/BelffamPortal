package com.bellfam.website.service.impl.post;

import com.bellfam.website.model.Post;
import com.bellfam.website.model.User;
import com.bellfam.website.repository.interf.post.PostRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.post.PostService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


/**
 * @author Eugene Petrov
 */
@Service
public class PostServiceImpl extends AbstractCRUDService<Post, Integer> implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    @Override
    protected CrudRepository<Post, Integer> getRepository() {
        return postRepository;
    }

    @Override
    public void createPost(Post post) {
        User user;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            user = userService.findUserByUsername(((UserDetails) principal).getUsername());
        } else {
            user = null;
        }
        post.setAuthor(user.getFirstName() + " " + user.getLastName());
        post.setDate(new java.util.Date());
        this.update(post);
    }
}
