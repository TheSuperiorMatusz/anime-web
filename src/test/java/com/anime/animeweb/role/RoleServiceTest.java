package com.anime.animeweb.role;

import com.anime.animeweb.role.Role;
import com.anime.animeweb.role.enums.UserRole;
import com.anime.animeweb.role.RoleRepository;
import com.anime.animeweb.role.RoleService;
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
public class RoleServiceTest {
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void shouldFindAllRoles() {
        List<Role> roleList = new ArrayList<>(List.of(new Role(), new Role()));
        int sizeOfRoleList = roleList.size();
        Mockito.when(roleRepository.findAll()).thenReturn(roleList);

        List<Role> roleListFromService = roleService.findAllEntities();

        Assertions.assertEquals(sizeOfRoleList, roleListFromService.size());
    }

    @Test
    public void shouldFindRole() throws ChangeSetPersister.NotFoundException {
        Long idRoleToFind = 1L;
        Role roleToFind = new Role();
        roleToFind.setRoleName(UserRole.ADMIN);
        Mockito.when(roleRepository.findById(idRoleToFind)).thenReturn(Optional.of(roleToFind));

        Role roleFromService = roleService.findById(idRoleToFind);

        Assertions.assertEquals(roleFromService.getRoleName(), roleFromService.getRoleName());
    }

    @Test
    public void shouldDeleteRoleWithGivenId() throws ChangeSetPersister.NotFoundException {
        Long roleId = 2L;
        roleService.deleteEntityFromDatabase(roleId);
        verify(roleRepository).deleteById(roleId);
    }

    @Test
    public void shouldAddRole() {
        Role role = new Role();
        role.setRoleName(UserRole.USER);
        Mockito.when(roleRepository.save(role)).thenReturn(role);

        Role roleFromService = roleService.addEntityToDatabase(role);

        Assertions.assertEquals(role.getRoleName(), roleFromService.getRoleName());
    }
}
