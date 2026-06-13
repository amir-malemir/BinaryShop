package online.shop.binary.base;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {
    
    @Autowired
    protected R repository;
    
    public List<T> findAll() {
        return repository.findAll();
    }
    
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }
    
    public T save(T entity) {
        return repository.save(entity);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}