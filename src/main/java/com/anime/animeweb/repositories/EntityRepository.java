package com.anime.animeweb.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@Configuration
@EnableJpaRepositories("com.anime.animeweb.model.entity")
public interface EntityRepository<E, K> extends CrudRepository<E, K> {
}
