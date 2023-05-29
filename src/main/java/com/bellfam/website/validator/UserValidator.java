package com.bellfam.website.validator;

import com.bellfam.website.model.User;
import com.bellfam.website.service.impl.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * @author Eugene Petrov
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User userToValidate = (User) target;
        Optional<User> userFromDB = userDetailsService.loadUserOptionalByUsername(userToValidate.getUsername());
        if (userFromDB.isPresent()) {
            errors.rejectValue("username", "400", "username already exist");
        }
    }
}
