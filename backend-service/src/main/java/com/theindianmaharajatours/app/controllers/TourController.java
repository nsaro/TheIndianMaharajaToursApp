package com.theindianmaharajatours.app.controllers;

import com.generated.code.api.TourApi;
import com.generated.code.model.QueryDto;
import com.generated.code.model.Tour;
import com.theindianmaharajatours.app.dao.entities.TourEntity;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.EmailService;
import com.theindianmaharajatours.app.services.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TourController implements TourApi{

    private final TourService tourService;
    private final DownloadService downloadService;
    private final EmailService emailService;

    TourController(TourService tourService, DownloadService downloadService, EmailService emailService) {
        this.tourService = tourService;
        this.downloadService = downloadService;
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tourEntities = this.tourService.getAllTours();
        return ResponseEntity.ok(tourEntities);
    }

    @Override
    public ResponseEntity<List<Tour>> getRandomTours() {
        List<Tour> tourEntities = this.tourService.getRandomTours();
        return ResponseEntity.ok(tourEntities);
    }

    @Override
    public ResponseEntity<List<Tour>> getToursByStateId(@PathVariable("id") Long id) {
        List<Tour> tourEntities = this.tourService.getToursByStateId(id);
        return ResponseEntity.ok(tourEntities);
    }

    @GetMapping("/tour/downloadThumbnail/{id}")
    public void downloadThumbnail(@PathVariable("id") Integer id, HttpServletResponse response)
            throws SQLException {
        TourEntity tourEntity = this.tourService.getTourById(id);
        this.downloadService.downloadFile(response, tourEntity.getThumbnailFilename(),
                tourEntity.getThumbnail().getBinaryStream());
    }

    @Override
    public ResponseEntity<Boolean> submitTourQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitTourQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Boolean> submitCustomTourQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitCustomTourQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }
}
