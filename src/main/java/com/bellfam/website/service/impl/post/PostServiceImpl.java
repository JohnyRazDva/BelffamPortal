package com.bellfam.website.service.impl.post;

import com.bellfam.website.model.Post;
import com.bellfam.website.service.interf.post.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Service
public class PostServiceImpl implements PostService {
    @Override
    public void create(Post entity) {

    }

    @Override
    public Post findById(Integer id) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post update(Post entity) {
        return null;
    }

    @Override
    public void delete(Post entity) {

    }
}
