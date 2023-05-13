package com.bellfam.website.service.interf;

import java.util.List;

/**
 * @author Eugene Petrov
 */
public interface CRUDService<E, K> {
    void create(E entity);

    E findById(K id);

    List<E> findAll();

    E update(E entity);

    void delete(E entity);
}
