package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.ItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {

    public List<ItineraryEntity> getItinerariesByTourId(long id);
}
