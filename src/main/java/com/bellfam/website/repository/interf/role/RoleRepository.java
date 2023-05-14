package com.bellfam.website.repository.interf.role;

import com.bellfam.website.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eugene Petrov
 */
@Repository
public interface  RoleRepository extends CrudRepository<Role, Integer> {
}
