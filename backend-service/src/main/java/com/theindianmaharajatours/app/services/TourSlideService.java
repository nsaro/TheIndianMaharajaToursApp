package com.theindianmaharajatours.app.services;

import com.generated.code.model.TourSlide;
import com.theindianmaharajatours.app.dao.entities.TourSlideEntity;
import com.theindianmaharajatours.app.dao.repository.TourSlideRepository;
import com.theindianmaharajatours.app.mappers.TourSlideMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class TourSlideService {
    private final TourSlideRepository tourSlideRepository;

    TourSlideService(TourSlideRepository tourSlideRepository) {
        this.tourSlideRepository = tourSlideRepository;
    }

    public void addTourSlide(TourSlideEntity tourSlideEntity) {
        this.tourSlideRepository.save(tourSlideEntity);
    }

    public void updateTourSlide(TourSlideEntity tourSlideEntity) {
        this.tourSlideRepository.save(tourSlideEntity);
    }

    public List<TourSlideEntity> listTourSlides() {
        return this.tourSlideRepository.findAll();
    }

    public void removeTourSlide(long id) {
        this.tourSlideRepository.delete(getTourSlide(id));
    }

    public TourSlideEntity getTourSlide(long id) {
        return this.tourSlideRepository.getOne(id);
    }

    public List<TourSlide> getTourSlidesByTourId(long id) {
        List<TourSlideEntity> tourSlideEntities = this.tourSlideRepository.getTourSlideEntitiesByTourId(id);
        if (tourSlideEntities.isEmpty())
        {
            throw new ResponseStatusException(NOT_FOUND, "Tour slides not found!");
        }
        return TourSlideMapper.INSTANCE.getTourSlides(tourSlideEntities);
    }
}
