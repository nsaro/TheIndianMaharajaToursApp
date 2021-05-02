package com.theindianmaharajatours.app.services;

import com.theindianmaharajatours.app.dao.entities.TourSlide;
import com.theindianmaharajatours.app.dao.repository.TourSlideRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TourSlideService {
    private final TourSlideRepository tourSlideRepository;

    TourSlideService(TourSlideRepository tourSlideRepository) {
        this.tourSlideRepository = tourSlideRepository;
    }

    public void addTourSlide(TourSlide tourSlide) {
        this.tourSlideRepository.save(tourSlide);
    }

    public void updateTourSlide(TourSlide tourSlide) {
        this.tourSlideRepository.save(tourSlide);
    }

    public List<TourSlide> listTourSlides() {
        return this.tourSlideRepository.findAll();
    }

    public void removeTourSlide(long id) {
        this.tourSlideRepository.delete(getTourSlide(id));
    }

    public TourSlide getTourSlide(long id) {
        return this.tourSlideRepository.getOne(id);
    }

    public List<TourSlide> getTourSlidesByTourId(long id) {
        return this.tourSlideRepository.getTourSlidesByTourId(id);
    }
}
