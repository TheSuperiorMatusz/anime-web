package com.anime.animeweb.user;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerSpringBootTest {
    @MockBean
    private UserService userService;

    @Autowired
    private TestRestTemplate restTemplate;

    private static String USER_URL = "/api/v1/users";

    @Test
    public void canRetrieveUsers() {
        User user = new User();
        user.setName("Tst");
        user.setAge(25);
        User user2 = new User();
        user2.setName("Tst2");
        user2.setAge(26);
        List<User> users = List.of(user, user2);

        given(userService.findAllEntities()).willReturn(users);

        ResponseEntity<User[]> usersResponse = restTemplate.getForEntity(USER_URL, User[].class);

        assertThat(usersResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(usersResponse.getBody()).hasSize(2);
    }

    @Test
    public void canRetrieveUser() throws ChangeSetPersister.NotFoundException {
        Long userId = 1L;
        User user = new User();
        user.setName("Tst");
        user.setAge(25);
        user.setId(userId);

        given(userService.findById(userId)).willReturn(user);

        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(USER_URL + "/" + userId, User.class);

        assertThat(userResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(userResponseEntity.getBody()).isEqualTo(user);
    }

    @Test
    public void canCreateUser() {
        User user = new User();
        user.setName("Tst");
        user.setAge(25);

        given(userService.addEntityToDatabase(user)).willReturn(user);

        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(USER_URL, user, User.class);

        assertThat(userResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(userResponseEntity.getBody()).isEqualTo(user);
    }

}
