package com.anime.animeweb.user;

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

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    public void shouldFindAllUsers() {
        List<User> usersList = new ArrayList<>(List.of(new User(), new User()));
        int sizeOfUserList = usersList.size();
        Mockito.when(userRepository.findAll()).thenReturn(usersList);

        List<User> usersFromService = userService.findAllEntities();

        Assertions.assertEquals(sizeOfUserList, usersFromService.size());
    }

    @Test
    public void shouldFindUser() throws ChangeSetPersister.NotFoundException {
        Long idUserToFind = 1L;
        User userToFind = new User();
        userToFind.setAge(25);
        userToFind.setName("Mark");
        Mockito.when(userRepository.findById(idUserToFind)).thenReturn(Optional.of(userToFind));

        User userFromService = userService.findById(idUserToFind);

        Assertions.assertEquals(userToFind.getAge(), userFromService.getAge());
        Assertions.assertEquals(userToFind.getName(), userFromService.getName());
    }

    @Test(expected = ChangeSetPersister.NotFoundException.class)
    public void shouldDeleteUserWithGivenId() throws ChangeSetPersister.NotFoundException {
        Long userId = 2L;

        userService.deleteEntityFromDatabase(userId);

    }

    @Test
    public void shouldUserAnime() {
        User user = new User();
        user.setName("Mark");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User userFromService = userService.addEntityToDatabase(user);

        Assertions.assertEquals(user.getName(), userFromService.getName());
    }
}
