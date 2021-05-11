package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {

    List<TourEntity> getTourEntitiesByStateId(long stateId);
}
