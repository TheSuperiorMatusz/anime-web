package com.anime.animeweb.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<E> extends CrudRepository<E, Long> {
}
