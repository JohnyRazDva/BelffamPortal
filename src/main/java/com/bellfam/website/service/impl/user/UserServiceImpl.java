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
import java.util.Optional;

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

    //TODO make exception for user not found
    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else throw new IllegalArgumentException();
    }

    @Override
    public int getUserRoleId(int userId) {
        Iterable<UserRole> userRoles = userRoleRepository.findAllByUserId(userId);
        UserRole userRole = userRoles.iterator().next();
        return userRole.getRoleId();
    }

    @Override
    public void updateUserRole(int userId, int roleId) {
        Iterable<UserRole> userRoles = userRoleRepository.findAllByUserId(userId);
        UserRole userRole = userRoles.iterator().next();
        userRole.setRoleId(roleId);
        userRoleRepository.save(userRole);
    }

    @Override
    public boolean checkUserPassword(int userId, String password){
        return passwordEncoder.matches(password,findById(userId).getPassword());
    }

    @Override
    public void changePassword(int userId, String password) {
        User user = findById(userId);
        user.setPassword(passwordEncoder.encode(password));
        update(user);
    }
}
