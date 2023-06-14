package com.bellfam.website.service.interf.link;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.Post;
import com.bellfam.website.service.interf.CRUDService;

/**
 * @author Eugene Petrov
 */
public interface LinkService extends CRUDService<Link, Integer> {
    void updateLink(String id, String linkValue, String description);
    void deleteLink(String id);
}
