package com.bellfam.website.service.impl;

import com.bellfam.website.service.interf.CRUDService;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene Petrov
 */
public abstract class AbstractCRUDService<E, K> implements CRUDService<E, K> {

    protected abstract CrudRepository<E, K> getRepository();

    @Override
    public void create(E object) {
        getRepository().save(object);
    }

    @Override
    public E findById(K id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public List<E> findAll() {
        List<E> objects = new ArrayList<>();
        getRepository().findAll().forEach(objects::add);
        return objects;
    }

    @Override
    public E update(E object) {
        getRepository().save(object);
        return object;
    }

    @Override
    public void delete(E object) {
        getRepository().delete(object);
    }
}
