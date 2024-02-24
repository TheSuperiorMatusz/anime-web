package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Comment;
import com.anime.animeweb.repositories.EntityRepository;

public class CommentService extends EntityService<Comment> {
    public CommentService(EntityRepository<Comment> repository) {
        super(repository);
    }
}
