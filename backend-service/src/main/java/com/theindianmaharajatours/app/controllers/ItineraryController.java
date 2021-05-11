package com.theindianmaharajatours.app.controllers;


import com.generated.code.api.ItineraryApi;
import com.generated.code.model.Itinerary;
import com.theindianmaharajatours.app.services.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ItineraryController implements ItineraryApi{
    private final ItineraryService itineraryService;

    ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @Override
    public ResponseEntity<List<Itinerary>> getItinerariesByTourId(@PathVariable Long id) {
        List<Itinerary> itinerariesByTourId = this.itineraryService.getItinerariesByTourId(id);
        return ResponseEntity.ok(itinerariesByTourId);
    }
}
