package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.TourSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourSlideRepository extends JpaRepository<TourSlide, Long> {

    public List<TourSlide> getTourSlidesByTourId(long tourId);
}
