package com.theindianmaharajatours.app.services;

import com.generated.code.model.Tour;
import com.theindianmaharajatours.app.dao.entities.TourEntity;
import com.theindianmaharajatours.app.dao.repository.TourRepository;
import com.theindianmaharajatours.app.mappers.TourMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class TourService {

    private final TourRepository tourRepository;

    TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public void addTour(TourEntity tourEntity) {
        this.tourRepository.save(tourEntity);
    }

    public void updateTour(TourEntity tourEntity) {
        this.tourRepository.save(tourEntity);
    }

    public List<Tour> getAllTours() {
        return TourMapper.INSTANCE.getTours(this.tourRepository.findAll());
    }

    public TourEntity getTourById(long id) {
        TourEntity tourEntity = this.tourRepository.findById(id).orElse(null);
        if (tourEntity == null)
        {
            throw new ResponseStatusException(NOT_FOUND, "Tour not found!");
        }
        return tourEntity;
    }

    public void removeTour(long id) {
        this.tourRepository.delete(getTourById(id));
    }

    public List<Tour> getToursByStateId(long id) {
        return TourMapper.INSTANCE.getTours(this.tourRepository.getTourEntitiesByStateId(id));
    }

    public List<Tour> getRandomTours() {
        List<Tour> allTours = getAllTours();
        List<Tour> random4Tours = new ArrayList<>();
        if (allTours.size() >= 4) {
            for (int i = 0; i < 4; ) {
                Tour tour = randomTour(allTours);
                if (!random4Tours.contains(tour)) {
                    random4Tours.add(tour);
                    i++;
                }
            }
        }
        return random4Tours;
    }

    private Tour randomTour(List<Tour> allTours) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(allTours.size());
        return allTours.get(index);
    }
}
