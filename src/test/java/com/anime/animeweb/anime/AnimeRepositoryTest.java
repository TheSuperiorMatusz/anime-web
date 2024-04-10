package com.anime.animeweb.anime;

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
public class AnimeRepositoryTest {

    @Autowired
    AnimeRepository animeRepository;


    @Test
    public void shouldPersistsAnimeThatIsSaved() {
        Anime animeToSave = new Anime();
        animeToSave.setDescription("test");
        animeToSave.setTitle("Dragon ball");
        Long id = animeRepository.save(animeToSave).getId();

        Optional<Anime> anime = animeRepository.findById(id);


        Assertions.assertEquals(anime.isPresent(), true);
    }

    @Test
    public void shouldReturnList() {
        Anime animeToSave = new Anime();
        animeToSave.setDescription("test");
        animeToSave.setTitle("Dragon ball");
        int size = 1;
        animeRepository.save(animeToSave);

        List<Anime> animeList = (List<Anime>) animeRepository.findAll();

        Assertions.assertEquals(animeList.size(), size);
    }

    @Test
    public void shouldDeleteAnime() {
        Anime animeToSave = new Anime();
        animeToSave.setDescription("test");
        animeToSave.setTitle("Dragon ball");
        Long animeIdToDelete = animeRepository.save(animeToSave).getId();

        animeRepository.deleteById(animeIdToDelete);

        Assertions.assertFalse(animeRepository.existsById(animeIdToDelete));
    }

}
