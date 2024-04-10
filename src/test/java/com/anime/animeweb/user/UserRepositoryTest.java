package com.anime.animeweb.user;


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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldPersistsUser() {
        User newUser = new User();
        newUser.setName("MarkDestroyer");
        newUser.setAge(21);
        Long id = userRepository.save(newUser).getId();

        Optional<User> user = userRepository.findById(id);

        Assertions.assertTrue(user.isPresent());
    }

    @Test
    public void shouldReturnList() {
        User newUser = new User();
        newUser.setName("MarkDestroyer");
        newUser.setAge(21);
        userRepository.save(newUser);
        int size = 1;


        List<User> users = (List<User>) userRepository.findAll();

        Assertions.assertEquals(users.size(), size);
    }

    @Test
    public void shouldDeleteUser() {
        User newUser = new User();
        newUser.setName("MarkDestroyer");
        newUser.setAge(21);
        Long id = userRepository.save(newUser).getId();

        userRepository.deleteById(id);

        Assertions.assertFalse(userRepository.existsById(id));
    }
}
