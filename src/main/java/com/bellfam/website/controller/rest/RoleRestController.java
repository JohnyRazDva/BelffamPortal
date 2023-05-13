package com.bellfam.website.controller.rest;

import com.bellfam.website.model.Role;
import com.bellfam.website.service.interf.CRUDService;
import com.bellfam.website.service.interf.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eugene Petrov
 */
@RestController
@RequestMapping(RoleRestController.ROLE_REST_URL)
public class RoleRestController extends CRUDRestController<Role, Integer> {

    public static final String ROLE_REST_URL = "role";

    @Autowired
    private RoleService roleService;

    @Override
    CRUDService<Role, Integer> getService() {
        return roleService;
    }
}
