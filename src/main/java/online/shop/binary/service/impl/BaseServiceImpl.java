package online.shop.binary.service.impl;

import java.util.List;

import java.util.Optional;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.base.BaseRepository;
import online.shop.binary.service.BaseService;

public abstract class BaseServiceImpl<T extends BaseEntity, R extends BaseRepository<T>> implements BaseService<T> {    
    
    protected final R repository;
    
    protected BaseServiceImpl(R repository) {
		this.repository = repository;
	}
    
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public T save(T entity) {
        return repository.save(entity);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}