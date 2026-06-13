package online.shop.binary.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<T extends BaseEntity, S extends BaseService<T, ?>> {
    
    @Autowired
    protected S service;
    
    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public T findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }
    
    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }
    
    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody T entity) {
        entity.setId(id);
        return service.save(entity);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}