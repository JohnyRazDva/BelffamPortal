package com.bellfam.website.controller.mvc;

import com.bellfam.website.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Petrov
 */
@Controller
@RequestMapping(RoleController.ROLE_URL)
public class RoleController extends CRUDController<Role, Integer> {

    public static final String ROLE_URL = "ui/role";
    public static final String ROLE_NAME = "role";

    @Override
    String getEntityName() {
        return ROLE_NAME;
    }
}
