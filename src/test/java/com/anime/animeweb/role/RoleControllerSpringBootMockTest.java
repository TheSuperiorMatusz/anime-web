package com.anime.animeweb.role;

import com.anime.animeweb.role.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class RoleControllerSpringBootMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Autowired
    private JacksonTester<Role> roleJacksonTester;

    @Autowired
    private JacksonTester<List<Role>> roleListJacksonTester;

    private static String ROLE_URL = "/api/v1/roles";

    @Test
    public void canRetrieveAllRoles() throws Exception {
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        Role role2 = new Role();
        role.setRoleName(UserRole.USER);
        List<Role> roles = List.of(role, role2);

        when(roleService.findAllEntities()).thenReturn(roles);

        MockHttpServletResponse response = mockMvc.perform(get(ROLE_URL).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(roleListJacksonTester.write(roles).getJson());
    }

    @Test
    public void canRetrieveRoleById() throws Exception {
        Long roleId = 1L;
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        role.setId(roleId);

        when(roleService.findById(roleId)).thenReturn(role);

        MockHttpServletResponse response = mockMvc.perform(get(ROLE_URL + "/" + roleId).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(roleJacksonTester.write(role).getJson());
    }

    @Test
    public void canCreateRole() throws Exception {
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        when(roleService.addEntityToDatabase(role)).thenReturn(role);

        MockHttpServletResponse response = mockMvc.perform(post(ROLE_URL).contentType(MediaType.APPLICATION_JSON)
                .content(roleJacksonTester.write(role).getJson())
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void canDeleteRole() throws Exception {
        Long roleId = 1L;
        Role role = new Role();
        role.setRoleName(UserRole.ADMIN);
        role.setId(roleId);
        when(roleService.findById(roleId)).thenReturn(role);

        MockHttpServletResponse response = mockMvc.perform(delete(ROLE_URL + "/" + roleId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
    }
}
