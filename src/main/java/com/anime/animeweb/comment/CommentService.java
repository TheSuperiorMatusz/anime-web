package com.anime.animeweb.comment;

import com.anime.animeweb.core.EntityRepository;
import com.anime.animeweb.core.EntityService;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends EntityService<Comment> {
    public CommentService(EntityRepository<Comment> repository) {
        super(repository);
    }
}
