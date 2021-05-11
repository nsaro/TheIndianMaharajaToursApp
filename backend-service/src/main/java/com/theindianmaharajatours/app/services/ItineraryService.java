package com.theindianmaharajatours.app.services;

import com.generated.code.model.Itinerary;
import com.theindianmaharajatours.app.dao.entities.ItineraryEntity;
import com.theindianmaharajatours.app.dao.repository.ItineraryRepository;
import com.theindianmaharajatours.app.mappers.ItineraryMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    ItineraryService(ItineraryRepository itineraryRepository){
        this.itineraryRepository = itineraryRepository;
    }
    public void addItinerary(ItineraryEntity itineraryEntity) {
        this.itineraryRepository.save(itineraryEntity);
    }

    public void updateItinerary(ItineraryEntity itineraryEntity) {
        this.itineraryRepository.save(itineraryEntity);
    }

    public List<ItineraryEntity> getItineraries() {
        return this.itineraryRepository.findAll();
    }

    public void removeItinerary(long id) {
        this.itineraryRepository.delete(this.itineraryRepository.getOne(id));
    }

    public List<Itinerary> getItinerariesByTourId(long id) {
        List<ItineraryEntity> itineraries = this.itineraryRepository.getItinerariesByTourId(id);
        if (itineraries.isEmpty())
        {
            throw new ResponseStatusException(NOT_FOUND, "Itineraries not found!");
        }
        return ItineraryMapper.INSTANCE.getItineraries(itineraries);

    }
}
