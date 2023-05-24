package com.bellfam.website.repository.impl.post;

import com.bellfam.website.model.Post;
import com.bellfam.website.repository.interf.post.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Eugene Petrov
 */

public class PostRepositoryImpl implements PostRepository {
    @Override
    public <S extends Post> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Post> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Post> findAll() {
        return null;
    }

    @Override
    public Iterable<Post> findAllById(Iterable<Integer> integers) {
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
    public void delete(Post entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
