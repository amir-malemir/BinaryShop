package online.shop.binary.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {

    @Autowired
    protected R repository;

    public T save(T entity) {
        return repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }
}