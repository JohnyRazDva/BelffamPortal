package com.bellfam.website.repository.interf.link;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eugene Petrov
 */
@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {
}
