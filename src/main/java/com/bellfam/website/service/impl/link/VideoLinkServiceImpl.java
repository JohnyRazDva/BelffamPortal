package com.bellfam.website.service.impl.link;

import com.bellfam.website.model.Link;
import com.bellfam.website.model.VideoLink;
import com.bellfam.website.repository.interf.link.LinkRepository;
import com.bellfam.website.repository.interf.link.VideoLinkRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.link.LinkService;
import com.bellfam.website.service.interf.link.VideoLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 * @author Eugene Petrov
 */
@Service
public class VideoLinkServiceImpl extends AbstractCRUDService<VideoLink, Integer> implements VideoLinkService {
    @Autowired
    VideoLinkRepository videoLinkRepository;

    @Override
    protected CrudRepository<VideoLink, Integer> getRepository() {
        return videoLinkRepository;
    }

    @Override
    public void updateVideoLink(String linkValue, String description) {
        VideoLink link = videoLinkRepository.findAll().iterator().next();
        link.setLinkValue(linkValue);
        link.setDescription(description);
        this.update(link);
    }

    @Override
    public void deleteVideoLink(String id) {
        int linkId = Integer.parseInt(id);
        VideoLink link = this.findById(linkId);
        this.delete(link);
    }

    @Override
    public VideoLink get() {
        return videoLinkRepository.findAll().iterator().next();
    }
}
