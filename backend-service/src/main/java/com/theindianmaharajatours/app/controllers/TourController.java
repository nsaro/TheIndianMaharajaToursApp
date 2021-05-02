package com.theindianmaharajatours.app.controllers;

import com.theindianmaharajatours.app.dao.entities.Tour;
import com.theindianmaharajatours.app.dtos.QueryDto;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.EmailService;
import com.theindianmaharajatours.app.services.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TourController {

    private final TourService tourService;
    private final DownloadService downloadService;
    private final EmailService emailService;

    TourController(TourService tourService, DownloadService downloadService, EmailService emailService) {
        this.tourService = tourService;
        this.downloadService = downloadService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/getAllTours")
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = this.tourService.getAllTours();
        return ResponseEntity.ok(tours);
    }

    @GetMapping(value = "/getRandomTours")
    public ResponseEntity<List<Tour>> getRandomTours() {
        List<Tour> tours = this.tourService.getRandomTours();
        return ResponseEntity.ok(tours);
    }

    @GetMapping(value = "/getToursByStateId/{id}")
    public ResponseEntity<List<Tour>> getToursByStateId(@PathVariable("id") Long id) {
        List<Tour> tours = this.tourService.getToursByStateId(id);
        return ResponseEntity.ok(tours);
    }

    @GetMapping("/tour/downloadThumbnail/{id}")
    public void downloadThumbnail(@PathVariable("id") Integer id, HttpServletResponse response)
            throws SQLException {
        Tour tour = this.tourService.getTourById(id);
        this.downloadService.downloadFile(response, tour.getThumbnailFilename(),
                tour.getThumbnail().getBinaryStream());
    }

    @GetMapping("/tour/submitTourQuery")
    public ResponseEntity<Boolean> submitTourQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitTourQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tour/submitCustomTourQuery")
    public ResponseEntity<Boolean> submitCustomTourQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitCustomTourQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }
}
