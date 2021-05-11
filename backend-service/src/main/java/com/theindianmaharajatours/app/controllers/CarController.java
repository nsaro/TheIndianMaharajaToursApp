package com.theindianmaharajatours.app.controllers;

import com.generated.code.api.CarApi;
import com.generated.code.model.Car;
import com.generated.code.model.QueryDto;
import com.theindianmaharajatours.app.dao.entities.CarEntity;
import com.theindianmaharajatours.app.services.CarService;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController implements CarApi {

    private final CarService carService;
    private final DownloadService downloadService;
    private final EmailService emailService;

    CarController(CarService carService, DownloadService downloadService, EmailService emailService) {
        this.carService = carService;
        this.downloadService = downloadService;
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = this.carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/car/downloadThumbnail/{id}")
    public void downloadCarThumbnail(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException {
        CarEntity carEntity = this.carService.getCar(id);
        this.downloadService.downloadFile(response, carEntity.getThumbnailFilename(),
                carEntity.getThumbnail().getBinaryStream());
    }

    @Override
    public ResponseEntity<Boolean> submitCarRentalQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitCarRentalQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }
}
