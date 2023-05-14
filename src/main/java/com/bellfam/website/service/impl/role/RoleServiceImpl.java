package com.bellfam.website.service.impl.role;

import com.bellfam.website.model.Role;
import com.bellfam.website.repository.interf.role.RoleRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Service
public class RoleServiceImpl extends AbstractCRUDService<Role, Integer> implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    protected CrudRepository<Role, Integer> getRepository() {
        return roleRepository;
    }
}
