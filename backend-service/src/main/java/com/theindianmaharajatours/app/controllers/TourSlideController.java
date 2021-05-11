package com.theindianmaharajatours.app.controllers;

import com.generated.code.api.TourSlideApi;
import com.generated.code.model.TourSlide;
import com.theindianmaharajatours.app.dao.entities.TourSlideEntity;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.TourSlideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TourSlideController implements TourSlideApi {
    private final TourSlideService tourSlideService;
    private final DownloadService downloadService;

    public TourSlideController(TourSlideService tourSlideService,
                               DownloadService downloadService) {
        this.tourSlideService = tourSlideService;
        this.downloadService = downloadService;

    }

    @Override
    public ResponseEntity<List<TourSlide>> getTourSlidesByTourId(@PathVariable Long id) {
        List<TourSlide> tourSlide = this.tourSlideService.getTourSlidesByTourId(id);
        return ResponseEntity.ok(tourSlide);
    }

    @GetMapping("/tourSlide/downloadThumbnail/{id}")
    public void downloadTourSlideThumbnail(@PathVariable("id") Long id,
                                           HttpServletResponse response) throws SQLException {
        TourSlideEntity tourSlideEntity = this.tourSlideService.getTourSlide(id);
        this.downloadService.downloadFile(response, tourSlideEntity.getTourSlideFilename(),
                tourSlideEntity.getTourSlider().getBinaryStream());
    }
}
