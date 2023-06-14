package com.bellfam.website.repository.interf.link;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.VideoLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eugene Petrov
 */
@Repository
public interface VideoLinkRepository extends CrudRepository<VideoLink, Integer> {
}
