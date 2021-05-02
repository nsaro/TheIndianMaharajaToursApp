package com.theindianmaharajatours.app.services;

import com.theindianmaharajatours.app.dao.entities.Itinerary;
import com.theindianmaharajatours.app.dao.repository.ItineraryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    ItineraryService(ItineraryRepository itineraryRepository){
        this.itineraryRepository = itineraryRepository;
    }
    public void addItinerary(Itinerary itinerary) {
        this.itineraryRepository.save(itinerary);
    }

    public void updateItinerary(Itinerary itinerary) {
        this.itineraryRepository.save(itinerary);
    }

    public List<Itinerary> getItineraries() {
        return this.itineraryRepository.findAll();
    }

    public void removeItinerary(long id) {
        this.itineraryRepository.delete(this.itineraryRepository.getOne(id));
    }

    public List<Itinerary> getItinerariesByTourId(long id) {
        return this.itineraryRepository.getItinerariesByTourId(id);
    }
}
