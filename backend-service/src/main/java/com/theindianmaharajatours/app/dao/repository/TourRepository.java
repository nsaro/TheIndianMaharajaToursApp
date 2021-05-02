package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> getToursByStateId(long stateId);
}
