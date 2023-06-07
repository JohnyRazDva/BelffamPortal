package com.bellfam.website.controller.rest;

import com.bellfam.website.model.Link;
import com.bellfam.website.service.interf.CRUDService;
import com.bellfam.website.service.interf.link.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author Eugene Petrov
 */
@RestController
@RequestMapping(LinkRestController.LINK_REST_URL)
public class LinkRestController extends CRUDRestController<Link, Integer> {

    public static final String LINK_REST_URL="link";

    @Autowired
    LinkService linkService;

    @Override
    CRUDService<Link, Integer> getService(){
        return linkService;
        }
}
