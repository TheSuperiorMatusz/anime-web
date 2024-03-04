package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Comment;
import com.anime.animeweb.repository.CommentRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @Test
    public void shouldFindAllComments() {
        List<Comment> commentsList = new ArrayList<>(List.of(new Comment(), new Comment()));
        int sizeOfCommentList = commentsList.size();
        Mockito.when(commentRepository.findAll()).thenReturn(commentsList);

        List<Comment> commentsFromService = commentService.findAllEntities();

        Assertions.assertEquals(sizeOfCommentList, commentsFromService.size());
    }

    @Test
    public void shouldFindComment() throws ChangeSetPersister.NotFoundException {
        Long idCommentToFind = 1L;
        Comment commentToFind = new Comment();
        commentToFind.setComment("Weak anime");
        Mockito.when(commentRepository.findById(idCommentToFind)).thenReturn(Optional.of(commentToFind));

        Comment commentFromService = commentService.findById(idCommentToFind);

        Assertions.assertEquals(commentToFind.getComment(), commentFromService.getComment());
    }

    @Test
    public void shouldDeleteCommentWithGivenId() {
        Long commentId = 2L;

        commentService.deleteEntityFromDatabase(commentId);

        verify(commentRepository).deleteById(commentId);
    }

    @Test
    public void shouldAddComment() {
        Comment comment = new Comment();
        comment.setComment("Weak anime");
        Mockito.when(commentRepository.save(comment)).thenReturn(comment);

        Comment commentFromService = commentService.addEntityToDatabase(comment);

        Assertions.assertEquals(comment.getComment(), commentFromService.getComment());
    }
}
