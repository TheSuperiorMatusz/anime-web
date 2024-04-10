package com.anime.animeweb.comment;

import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends EntityRepository<Comment> {
}
