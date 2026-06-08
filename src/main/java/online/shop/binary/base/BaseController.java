package online.shop.binary.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<T extends BaseEntity, S extends BaseService<T, ?>> {

    @Autowired
    protected S service;

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }
}