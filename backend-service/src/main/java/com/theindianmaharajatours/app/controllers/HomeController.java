package com.theindianmaharajatours.app.controllers;

import com.generated.code.model.QueryDto;
import com.theindianmaharajatours.app.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HomeController {
    private final EmailService emailService;

    public HomeController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/submitGeneralCustomerQuery")
    public ResponseEntity<Boolean> submitGeneralCustomerQuery(@RequestBody QueryDto queryDto) {
        boolean result = this.emailService.submitGeneralCustomerQueryEmailToExecutive(queryDto);
        return ResponseEntity.ok(result);
    }
}
