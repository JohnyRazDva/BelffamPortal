package com.bellfam.website.repository.impl.role;

import com.bellfam.website.model.Role;
import com.bellfam.website.repository.interf.role.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Eugene Petrov
 */

public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public <S extends Role> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Role> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Role> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Iterable<Role> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
