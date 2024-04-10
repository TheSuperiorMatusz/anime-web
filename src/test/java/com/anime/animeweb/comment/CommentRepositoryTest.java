package com.anime.animeweb.comment;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void shouldPersistsCommentThatIsSaved() {
        Comment newComment = new Comment();
        newComment.setComment("I agree XYZ is Marvelous anime\"");
        Long id = commentRepository.save(newComment).getId();

        Optional<Comment> comment = commentRepository.findById(id);


        Assertions.assertTrue(comment.isPresent());
    }

    @Test
    public void shouldReturnList() {
        Comment newComment = new Comment();
        newComment.setComment("I agree XYZ is Marvelous anime");
        int size = 1;
        commentRepository.save(newComment);

        List<Comment> commentList = (List<Comment>) commentRepository.findAll();

        Assertions.assertEquals(commentList.size(), size);
    }

    @Test
    public void shouldDeleteComment() {
        Comment newComment = new Comment();
        newComment.setComment("I agree XYZ is Marvelous anime\"");
        Long id = commentRepository.save(newComment).getId();

        commentRepository.deleteById(id);

        Assertions.assertFalse(commentRepository.existsById(id));
    }
}
