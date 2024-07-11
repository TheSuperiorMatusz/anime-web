package com.anime.animeweb.studio;

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
public class StudioControllerSpringBootMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudioService studioService;

    @Autowired
    private JacksonTester<Studio> studioJacksonTester;

    @Autowired
    private JacksonTester<List<Studio>> listJacksonTester;

    private final static String STUDIO_URL = "/api/v1/studios";

    @Test
    public void canRetrieveAllStudios() throws Exception {
        Studio studio = new Studio();
        studio.setName("Mappa");
        Studio studio2 = new Studio();
        studio2.setName("WIT");
        List<Studio> studios = List.of(studio, studio2);

        when(studioService.findAllEntities()).thenReturn(studios);

        MockHttpServletResponse response = mockMvc.perform(get(STUDIO_URL).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(listJacksonTester.write(studios).getJson());
    }

    @Test
    public void canRetrieveStudioById() throws Exception {
        Long studioId = 1L;
        Studio studio = new Studio();
        studio.setId(studioId);
        studio.setName("Mappa");

        when(studioService.findById(studioId)).thenReturn(studio);

        MockHttpServletResponse response = mockMvc.perform(get(STUDIO_URL + "/" + studioId)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(studioJacksonTester.write(studio).getJson());
    }

    @Test
    public void canCreateStudio() throws Exception {
        Studio studio = new Studio();
        studio.setName("Mappa");
        when(studioService.addEntityToDatabase(studio)).thenReturn(studio);

        MockHttpServletResponse response = mockMvc.perform(post(STUDIO_URL).contentType(MediaType.APPLICATION_JSON)
                .content(studioJacksonTester.write(studio).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void canDeleteStudio() throws Exception {
        Long studioId = 1L;
        Studio studio = new Studio();
        studio.setId(studioId);
        studio.setName("Mappa");

        when(studioService.findById(studioId)).thenReturn(studio);

        MockHttpServletResponse response = mockMvc.perform(delete(STUDIO_URL + "/" + studioId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
