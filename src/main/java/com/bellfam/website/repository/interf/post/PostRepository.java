package com.bellfam.website.repository.interf.post;

import com.bellfam.website.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eugene Petrov
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
