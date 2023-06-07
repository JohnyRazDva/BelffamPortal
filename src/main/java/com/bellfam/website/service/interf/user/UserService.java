package com.bellfam.website.service.interf.user;

import com.bellfam.website.model.User;
import com.bellfam.website.service.interf.CRUDService;

/**
 * @author Eugene Petrov
 */
public interface UserService extends CRUDService<User, Integer> {
    User findUserByUsername(String username);

    int getUserRoleId(int userId);

    void updateUserRole(int userId, int roleId);

    boolean checkUserPassword(int userId, String password);

    void changePassword(int userId, String password);
}

