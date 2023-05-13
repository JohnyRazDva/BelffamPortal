package com.bellfam.website.service.impl.user;

import com.bellfam.website.model.User;
import com.bellfam.website.service.interf.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Eugene Petrov
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }
}
