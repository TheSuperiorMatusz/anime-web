package com.anime.animeweb.studio;

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
public class StudioRepositoryTest {

    @Autowired
    StudioRepository studioRepository;


    @Test
    public void shouldPersistsStudio() {
        Studio newStudio = new Studio();
        newStudio.setName("Mappa");
        newStudio.setYear(2011);
        Long id = studioRepository.save(newStudio).getId();

        Optional<Studio> studio = studioRepository.findById(id);

        Assertions.assertTrue(studio.isPresent());
    }

    @Test
    public void shouldReturnList() {
        Studio newStudio = new Studio();
        newStudio.setName("Mappa");
        newStudio.setYear(2011);
        int size = 1;
        studioRepository.save(newStudio);

        List<Studio> studioList = (List<Studio>) studioRepository.findAll();

        Assertions.assertEquals(studioList.size(), size);
    }

    @Test
    public void shouldDeleteReview() {
        Studio newStudio = new Studio();
        newStudio.setName("Mappa");
        newStudio.setYear(2011);
        Long id = studioRepository.save(newStudio).getId();

        studioRepository.deleteById(id);

        Assertions.assertFalse(studioRepository.existsById(id));
    }
}
