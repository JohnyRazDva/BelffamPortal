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

import java.util.Optional;

/**
 * @author Eugene Petrov
 */
@Service
public class VideoLinkServiceImpl extends AbstractCRUDService<VideoLink, Integer> implements VideoLinkService {
    @Autowired
    private VideoLinkRepository videoLinkRepository;

    @Override
    protected CrudRepository<VideoLink, Integer> getRepository() {
        return videoLinkRepository;
    }

    @Override
    public void updateVideoLink(int id, String linkValue, String description) {
        Optional<VideoLink> link = videoLinkRepository.findById(id);
        if (link.isEmpty()) {
            //TODO throw custom exception
        } else {
            VideoLink resultLink = link.get();
            if (!linkValue.isEmpty()) {
                resultLink.setLinkValue(linkValue);
            }
            if (!description.isEmpty()) {
                resultLink.setDescription(description);
            }
            this.update(resultLink);
        }
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
