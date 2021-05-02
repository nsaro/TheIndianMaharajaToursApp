package com.theindianmaharajatours.app.controllers;

import com.theindianmaharajatours.app.dao.entities.TourSlide;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.TourSlideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TourSlideController {
    private final TourSlideService tourSlideService;
    private final DownloadService downloadService;

    public TourSlideController(TourSlideService tourSlideService,
                               DownloadService downloadService) {
        this.tourSlideService = tourSlideService;
        this.downloadService = downloadService;

    }

    @GetMapping("/getTourSlidesByTourId/{id}")
    public ResponseEntity<List<TourSlide>> getTourSlidesByTourId(@PathVariable Long id) {
        List<TourSlide> tourSlides = this.tourSlideService.getTourSlidesByTourId(id);
        return ResponseEntity.ok(tourSlides);
    }

    @GetMapping("/tourSlide/downloadThumbnail/{id}")
    public void downloadTourSlideThumbnail(@PathVariable("id") Long id,
                                           HttpServletResponse response) throws SQLException {
        TourSlide tourSlide = this.tourSlideService.getTourSlide(id);
        this.downloadService.downloadFile(response, tourSlide.getTourSlideFilename(),
                tourSlide.getTourSlider().getBinaryStream());
    }
}
