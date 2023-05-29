package com.bellfam.website.repository.interf.user;


import com.bellfam.website.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Eugene Petrov
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    Iterable<UserRole> findAllByUserId(int userId);
}
