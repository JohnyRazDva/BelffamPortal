package com.bellfam.website.service.impl.user;

import com.bellfam.website.model.User;
import com.bellfam.website.model.UserRole;
import com.bellfam.website.repository.interf.role.RoleRepository;
import com.bellfam.website.repository.interf.user.UserRepository;
import com.bellfam.website.repository.interf.user.UserRoleRepository;
import com.bellfam.website.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Eugene Petrov
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = loadUserOptionalByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userOptional.get();
        setAuthorities(user);
        return new UserDetailsImpl(user);
    }

    public Optional<User> loadUserOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void setAuthorities(User user) {
        int id = user.getId();
        List<UserRole> userRoles = (List<UserRole>) userRoleRepository.findAllByUserId(id);
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();
        List<String> authorities = roleIds.stream().map(roleId -> roleRepository.findById(roleId).get().getTitle()).toList();
        user.setAuthorities(authorities);
    }
}
