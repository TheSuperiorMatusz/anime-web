package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Anime;
import com.anime.animeweb.repositories.AnimeRepository;
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
public class AnimeServiceTest {
    @Mock
    private AnimeRepository animeRepository;

    @InjectMocks
    private AnimeService animeService;

    @Test
    public void shouldFindAllAnime() {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime(), new Anime()));
        int sizeOfAnimeList = animeList.size();
        Mockito.when(animeRepository.findAll()).thenReturn(animeList);
        List<Anime> animeFromService = animeService.findAllEntities();
        Assertions.assertEquals(sizeOfAnimeList, animeFromService.size());
    }

    @Test
    public void shouldFindAnime() throws ChangeSetPersister.NotFoundException {
        Long idAnimeToFind = 1L;
        Anime animeToFind = new Anime();
        animeToFind.setDescription("Ninja Kamui Ninja Kamui");
        animeToFind.setYear(2014);
        animeToFind.setTitle("Ninja Kamui");
        Mockito.when(animeRepository.findById(idAnimeToFind)).thenReturn(Optional.of(animeToFind));

        Anime animeFromService = animeService.findById(idAnimeToFind);

        Assertions.assertEquals(animeToFind.getDescription(), animeFromService.getDescription());
        Assertions.assertEquals(animeToFind.getTitle(), animeFromService.getTitle());
        Assertions.assertEquals(animeToFind.getYear(), animeFromService.getYear());
    }
}
