package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Comment;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends EntityService<Comment> {
    public CommentService(EntityRepository<Comment> repository) {
        super(repository);
    }
}
