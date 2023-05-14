package com.bellfam.website.service.impl.post;

import com.bellfam.website.model.Post;
import com.bellfam.website.repository.interf.post.PostRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


/**
 * @author Eugene Petrov
 */
@Service
public class PostServiceImpl extends AbstractCRUDService<Post, Integer> implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    protected CrudRepository<Post, Integer> getRepository() {
        return postRepository;
    }
}
