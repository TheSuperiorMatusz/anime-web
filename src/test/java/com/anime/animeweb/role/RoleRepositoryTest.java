package com.anime.animeweb.role;


import com.anime.animeweb.role.enums.UserRole;
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
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;


    @Test
    public void shouldPersistsRole() {
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        Long id = roleRepository.save(role).getId();

        Optional<Role> roleFromRepository = roleRepository.findById(id);

        Assertions.assertTrue(roleFromRepository.isPresent());
    }

    @Test
    public void shouldReturnList() {
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        int size = 1;
        roleRepository.save(role);

        List<Role> roleList = (List<Role>) roleRepository.findAll();

        Assertions.assertEquals(roleList.size(), size);
    }

    @Test
    public void shouldDeleteRole() {
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        Long id = roleRepository.save(role).getId();

        roleRepository.deleteById(id);

        Assertions.assertFalse(roleRepository.existsById(id));
    }
}
