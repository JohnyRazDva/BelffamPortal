package com.bellfam.website.controller.rest;

import com.bellfam.website.model.User;
import com.bellfam.website.service.interf.CRUDService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eugene Petrov
 */
@RestController
@RequestMapping(UserRestController.USER_REST_URL)
public class UserRestController extends CRUDRestController<User, Integer> {

    public static final String USER_REST_URL = "user";

    @Autowired
    private UserService userService;

    @Override
    CRUDService<User, Integer> getService() {
        return userService;
    }
}
