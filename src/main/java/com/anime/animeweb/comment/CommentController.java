package com.anime.animeweb.comment;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController extends EntityController<Comment> {
    public CommentController(EntityService<Comment> service) {
        super(service);
    }
}
