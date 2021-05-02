package com.theindianmaharajatours.app.services;

import com.theindianmaharajatours.app.dao.entities.Tour;
import com.theindianmaharajatours.app.dao.repository.TourRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class TourService {

    private final TourRepository tourRepository;

    TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public void addTour(Tour tour) {
        this.tourRepository.save(tour);
    }

    public void updateTour(Tour tour) {
        this.tourRepository.save(tour);
    }

    public List<Tour> getAllTours() {
        return this.tourRepository.findAll();
    }

    public Tour getTourById(long id) {
        return this.tourRepository.getOne(id);
    }

    public void removeTour(long id) {
        this.tourRepository.delete(getTourById(id));
    }

    public List<Tour> getToursByStateId(long id) {
        return this.tourRepository.getToursByStateId(id);
    }

    public List<Tour> getRandomTours() {
        List<Tour> allTours = getAllTours();
        List<Tour> random4tours = new ArrayList<>();
        if (allTours.size() >= 4) {
            for (int i = 0; i < 4; ) {
                Tour tour = randomTour(allTours);
                if (!random4tours.contains(tour)) {
                    random4tours.add(tour);
                    i++;
                }
            }
        }
        return random4tours;
    }

    private Tour randomTour(List<Tour> allTours) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(allTours.size());
        return allTours.get(index);
    }
}
