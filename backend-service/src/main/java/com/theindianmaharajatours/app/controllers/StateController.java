package com.theindianmaharajatours.app.controllers;

import com.theindianmaharajatours.app.dao.entities.State;
import com.theindianmaharajatours.app.services.DownloadService;
import com.theindianmaharajatours.app.services.StateService;
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
public class StateController {

    private final StateService stateService;
    private final DownloadService downloadService;

    StateController(StateService stateService, DownloadService downloadService) {
        this.stateService = stateService;
        this.downloadService = downloadService;
    }

    @GetMapping("/getAllStates")
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = this.stateService.getAllStates();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/getState/{id}")
    public ResponseEntity<State> getStateById(@PathVariable("id") Long id) {
        State state = this.stateService.getStateById(id);
        return ResponseEntity.ok(state);
    }

    @GetMapping("/state/downloadThumbnail/{id}")
    public void downloadThumbnail(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException {
        State state = this.stateService.getStateById(id);
        this.downloadService.downloadFile(response, state.getThumbnailFilename(),
                state.getThumbnail().getBinaryStream());
    }

    @GetMapping("/state/downloadBigImage/{id}")
    public void downloadBigImage(@PathVariable("id") Long id, HttpServletResponse response)
            throws SQLException {
        State state = this.stateService.getStateById(id);
        this.downloadService.downloadFile(response, state.getThumbnailFilename(),
                state.getBigImage().getBinaryStream());
    }
}
