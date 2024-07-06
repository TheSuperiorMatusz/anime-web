package com.anime.animeweb.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
public abstract class EntityService<E> {
    private final EntityRepository<E> repository;

    @Transactional
    public E addEntityToDatabase(E entity) {
        return repository.save(entity);
    }

    @Transactional
    public void deleteEntityFromDatabase(Long id) throws ChangeSetPersister.NotFoundException {
        var entity = this.findById(id);
        repository.delete(entity);
    }

    public List<E> findAllEntities() {
        return (List<E>) repository.findAll();
    }

    public E findById(Long id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
