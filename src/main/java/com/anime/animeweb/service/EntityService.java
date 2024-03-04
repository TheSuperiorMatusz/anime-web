package com.anime.animeweb.service;

import com.anime.animeweb.repository.EntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


@AllArgsConstructor
public class EntityService<E> {
    private final EntityRepository<E> repository;

    public E addEntityToDatabase(E entity) {
        return repository.save(entity);
    }

    public void deleteEntityFromDatabase(Long id) {
        repository.deleteById(id);
    }

    public List<E> findAllEntities() {
        return (List<E>)repository.findAll();
    }

    public E findById(Long id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
