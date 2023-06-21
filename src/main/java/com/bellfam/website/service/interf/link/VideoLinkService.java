package com.bellfam.website.service.interf.link;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.VideoLink;
import com.bellfam.website.service.interf.CRUDService;

/**
 * @author Eugene Petrov
 */
public interface VideoLinkService extends CRUDService<VideoLink, Integer> {
    void updateVideoLink(int id, String linkValue, String description);
    void deleteVideoLink(String id);
    VideoLink get();
}
