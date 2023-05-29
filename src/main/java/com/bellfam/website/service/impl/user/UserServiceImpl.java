package com.bellfam.website.service.impl.user;

import com.bellfam.website.model.Roles;
import com.bellfam.website.model.User;
import com.bellfam.website.model.UserRole;
import com.bellfam.website.repository.interf.role.RoleRepository;
import com.bellfam.website.repository.interf.user.UserRepository;
import com.bellfam.website.repository.interf.user.UserRoleRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Service
public class UserServiceImpl extends AbstractCRUDService<User, Integer> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected CrudRepository<User, Integer> getRepository() {
        return userRepository;
    }

    @Override
    public void create(User user) {
        //encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //save into  user_table
        getRepository().save(user);

        //save user and role into user_role
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        //set user default role ROLE_USER
        userRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());

        userRoleRepository.save(userRole);
    }
}
