package online.shop.binary.service;

import java.util.List;
import java.util.Optional;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.base.BaseRepository;

public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {
    
    
    protected final R repository;
    
    protected BaseService(R repository) {
		this.repository = repository;
	}
    
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