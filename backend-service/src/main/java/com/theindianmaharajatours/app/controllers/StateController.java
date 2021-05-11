package com.theindianmaharajatours.app.controllers;

import com.generated.code.api.StateApi;
import com.generated.code.model.State;
import com.theindianmaharajatours.app.dao.entities.StateEntity;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StateController implements StateApi {

    private final StateService stateService;
    private final DownloadService downloadService;

    StateController(StateService stateService, DownloadService downloadService) {
        this.stateService = stateService;
        this.downloadService = downloadService;
    }

    @Override
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = this.stateService.getAllStates();
        return ResponseEntity.ok(states);
    }

    @Override
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id) {
        State state = this.stateService.getStateById(id);
        return ResponseEntity.ok(state);
    }

    @GetMapping("/state/downloadThumbnail/{id}")
    public void downloadThumbnail(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException {
        StateEntity stateEntity = this.stateService.getStateEntityById(id);
        this.downloadService.downloadFile(response, stateEntity.getThumbnailFilename(),
                stateEntity.getThumbnail().getBinaryStream());
    }

    @GetMapping("/state/downloadBigImage/{id}")
    public void downloadBigImage(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException {
        StateEntity stateEntity = this.stateService.getStateEntityById(id);
        this.downloadService.downloadFile(response, stateEntity.getThumbnailFilename(),
                stateEntity.getBigImage().getBinaryStream());
    }
}
