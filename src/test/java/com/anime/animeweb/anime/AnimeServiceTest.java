package com.anime.animeweb.anime;

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

    @Test
    public void shouldDeleteAnimeWithGivenId() throws ChangeSetPersister.NotFoundException {
        Long animeId = 2L;
        animeService.deleteEntityFromDatabase(animeId);
        verify(animeRepository).deleteById(animeId);
    }

    @Test
    public void shouldAddAnime() {
        Anime anime = new Anime();
        anime.setTitle("Jujutsu Kaisen");
        Mockito.when(animeRepository.save(anime)).thenReturn(anime);

        Anime animeFromService = animeService.addEntityToDatabase(anime);

        Assertions.assertEquals(anime.getTitle(), animeFromService.getTitle());
    }
}
