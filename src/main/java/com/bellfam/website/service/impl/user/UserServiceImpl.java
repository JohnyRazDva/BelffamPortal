package com.bellfam.website.service.impl.user;

import com.bellfam.website.model.User;
import com.bellfam.website.repository.interf.user.UserRepository;
import com.bellfam.website.service.impl.AbstractCRUDService;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Service
public class UserServiceImpl extends AbstractCRUDService<User, Integer> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    protected CrudRepository<User, Integer> getRepository() {
        return userRepository;
    }
}
