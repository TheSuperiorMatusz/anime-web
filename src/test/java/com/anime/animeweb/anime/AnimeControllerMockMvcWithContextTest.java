package com.anime.animeweb.anime;

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
@WebMvcTest(AnimeController.class)
@Import(SecurityConfiguration.class)
public class AnimeControllerMockMvcWithContextTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnimeService animeService;

    @Autowired
    private JacksonTester<Anime> jsonAnime;

    @Autowired
    private JacksonTester<List<Anime>> jsonAnimeList;

    private final static String ANIME_URL = "/api/v1/animes";

    @Test
    public void canRetrieveAllAnime() throws Exception {
        Anime anime = new Anime();
        anime.setId(1L);
        anime.setTitle("Naruto");
        List<Anime> animeList = List.of(anime);
        when(animeService.findAllEntities()).thenReturn(animeList);

        MockHttpServletResponse response = mvc.perform(get(ANIME_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonAnimeList.write(animeList).getJson());
    }

    @Test
    public void canRetrieveOneAnime() throws Exception {
        Anime anime = new Anime();
        anime.setId(1L);
        anime.setTitle("Naruto");

        when(animeService.findById(anime.getId())).thenReturn(anime);

        MockHttpServletResponse response = mvc.perform(get(ANIME_URL+"/" + anime.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonAnime.write(anime).getJson());
    }

    @Test
    public void canDeleteAnime() throws Exception {
        Anime anime = new Anime();
        anime.setId(1L);
        anime.setTitle("Naruto");

        when(animeService.findById(anime.getId())).thenReturn(anime);

        MockHttpServletResponse response = mvc.perform(delete(ANIME_URL+"/" + anime.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void canAddAnime() throws Exception {
        Anime anime = new Anime();
        anime.setTitle("Naruto");
        anime.setYear(2000);

        when(animeService.addEntityToDatabase(anime)).thenReturn(anime);


        MockHttpServletResponse response = mvc.perform(post(ANIME_URL).contentType(MediaType.APPLICATION_JSON).content(
                jsonAnime.write(anime).getJson()
        )).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
