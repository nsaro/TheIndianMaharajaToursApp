package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.TourSlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourSlideRepository extends JpaRepository<TourSlideEntity, Long> {

    List<TourSlideEntity> getTourSlideEntitiesByTourId(long id);
}
