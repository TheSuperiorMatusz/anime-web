package com.anime.animeweb.comment;

import com.anime.animeweb.configuration.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureJsonTesters
@WebMvcTest(CommentController.class)
@Import(SecurityConfiguration.class)
public class CommentControllerMockWithContextTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommentService commentService;

    @Autowired
    private JacksonTester<List<Comment>> listCommentJson;

    @Autowired
    private JacksonTester<Comment> commentJson;

    private static final String COMMENT_URL = "/api/v1/comments";


    @Test
    public void canRetrieveAllComments() throws Exception {
        Comment comment = new Comment();
        comment.setComment("Test comment");
        List<Comment> comments = List.of(comment);
        when(commentService.findAllEntities()).thenReturn(comments);


        MockHttpServletResponse response = mvc.perform(get(COMMENT_URL).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(listCommentJson.write(comments).getJson());
    }

    @Test
    public void canRetrieveCommentById() throws Exception {
        Long commentId = 1L;
        Comment comment = new Comment();
        comment.setComment("Test comment");
        when(commentService.findById(commentId)).thenReturn(comment);

        MockHttpServletResponse response = mvc.perform(get(COMMENT_URL + "/" + commentId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(commentJson.write(comment).getJson());
    }

    @Test
    public void canDeleteComment() throws Exception {
        Long commentId = 1L;
        Comment comment = new Comment();
        comment.setComment("Test comment");
        when(commentService.findById(commentId)).thenReturn(comment);

        MockHttpServletResponse response = mvc.perform(delete(COMMENT_URL + "/" + commentId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void canAddComment() throws Exception{
        Comment comment = new Comment();
        comment.setComment("Test");

        when(commentService.addEntityToDatabase(comment)).thenReturn(comment);

        MockHttpServletResponse response = mvc.perform(post(COMMENT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(commentJson.write(comment).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
