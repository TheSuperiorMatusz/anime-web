package com.anime.animeweb.studio;

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
public class StudioServiceTest {
    @Mock
    private StudioRepository studioRepository;

    @InjectMocks
    private StudioService studioService;

    @Test
    public void shouldFindAllStudio() {
        List<Studio> studioList = new ArrayList<>(List.of(new Studio(), new Studio()));
        int sizeOfStudioList = studioList.size();
        Mockito.when(studioRepository.findAll()).thenReturn(studioList);

        List<Studio> studiosFromService = studioService.findAllEntities();

        Assertions.assertEquals(sizeOfStudioList, studiosFromService.size());
    }

    @Test
    public void shouldFindStudio() throws ChangeSetPersister.NotFoundException {
        Long idStudioToFind = 1L;
        Studio studioToFind = new Studio();
        studioToFind.setName("Mappa");
        Mockito.when(studioRepository.findById(idStudioToFind)).thenReturn(Optional.of(studioToFind));

        Studio studioFromService = studioService.findById(idStudioToFind);

        Assertions.assertEquals(studioToFind.getName(), studioFromService.getName());
    }

    @Test
    public void shouldDeleteStudioWithGivenId() throws ChangeSetPersister.NotFoundException {
        Long studioId = 2L;

        studioService.deleteEntityFromDatabase(studioId);

        verify(studioRepository).deleteById(studioId);
    }

    @Test
    public void shouldAddStudio() {
        Studio studioToSave = new Studio();
        studioToSave.setName("Mappa");
        Mockito.when(studioRepository.save(studioToSave)).thenReturn(studioToSave);

        Studio studioFromService = studioService.addEntityToDatabase(studioToSave);

        Assertions.assertEquals(studioToSave.getName(), studioFromService.getName());
    }
}
