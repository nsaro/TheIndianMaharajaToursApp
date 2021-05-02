package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    public List<Itinerary> getItinerariesByTourId(long id);
}
