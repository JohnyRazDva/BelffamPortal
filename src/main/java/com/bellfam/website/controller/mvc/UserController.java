package com.bellfam.website.controller.mvc;

import com.bellfam.website.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping(UserController.USER_URL)
public class UserController  extends CRUDController<User, Integer>{

    public static final String USER_URL = "ui/user";
    public static final String USER_NAME = "user";

    @Override
    String getEntityName() {
        return USER_NAME;
    }
}
