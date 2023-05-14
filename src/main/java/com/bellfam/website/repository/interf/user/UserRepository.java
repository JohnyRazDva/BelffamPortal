package com.bellfam.website.repository.interf.user;

import com.bellfam.website.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eugene Petrov
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
