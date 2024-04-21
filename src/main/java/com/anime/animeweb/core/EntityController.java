package com.anime.animeweb.core;


import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

public abstract class EntityController<T> {
    private final EntityService<T> service;

    @GetMapping("")
    public List<T> getEntities() {
        return service.findAllEntities();
    }

    @GetMapping("/{id}")
    public T getEntityById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return service.findById(id);
    }

    @PostMapping("")
    public T createNewEntity(@RequestBody T entity) {
        return service.addEntityToDatabase(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        service.deleteEntityFromDatabase(id);
    }

}
