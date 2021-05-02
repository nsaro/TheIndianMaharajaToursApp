package com.theindianmaharajatours.app.controllers;


import com.theindianmaharajatours.app.dao.entities.Itinerary;
import com.theindianmaharajatours.app.services.ItineraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ItineraryController {
    private final ItineraryService itineraryService;

    ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping("/getItinerariesByTourId/{id}")
    public ResponseEntity<List<Itinerary>> getItinerariesByTourId(@PathVariable Long id) {
        List<Itinerary> itinerariesByTourId = this.itineraryService.getItinerariesByTourId(id);
        return ResponseEntity.ok(itinerariesByTourId);
    }
}
