package com.theindianmaharajatours.app.state;

import com.generated.code.model.Tour;
import com.theindianmaharajatours.app.dao.entities.TourEntity;
import com.theindianmaharajatours.app.dao.repository.TourRepository;
import com.theindianmaharajatours.app.services.TourService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {

    @InjectMocks
    private TourService tourService;

    @Mock
    private TourRepository tourRepository;

    @Test
    void shouldGetAllTours_whenAskedForAllTours() {
        when(tourRepository.findAll()).thenReturn(singletonList(getTourEntity()));
        List<Tour> allTours = tourService.getAllTours();
        Assertions.assertEquals(allTours.size(), 1);
        Assertions.assertEquals(allTours.get(0).getName(), getTourEntity().getName());
    }

    @Test
    void shouldGetTourById_whenAskedForTourById() {
        when(tourRepository.findById(1L)).thenReturn(Optional.of(getTourEntity()));
        TourEntity tourEntity = tourService.getTourById(1L);
        Assertions.assertEquals(tourEntity.getName(), getTourEntity().getName());
    }

    @Test
    void shouldGetToursByStateId_whenAskedForToursByStateId(){
        when(tourRepository.getTourEntitiesByStateId(1L)).thenReturn(singletonList(getTourEntity()));
        List<Tour> allTours = tourService.getToursByStateId(1L);
        Assertions.assertEquals(allTours.get(0).getName(), getTourEntity().getName());
    }

    private TourEntity getTourEntity() {
        TourEntity tourEntity = new TourEntity();
        tourEntity.setStateId(1L);
        tourEntity.setName("Delhi Tour");
        tourEntity.setStateId(1L);
        tourEntity.setCities("New Delhi, Delhi");
        tourEntity.setThumbnailFilename("Thumbnail file name");
        return tourEntity;
    }
}
