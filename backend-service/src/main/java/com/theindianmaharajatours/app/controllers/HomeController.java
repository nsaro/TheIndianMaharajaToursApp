package com.theindianmaharajatours.app.controllers;

import com.theindianmaharajatours.app.dtos.QueryDto;
import com.theindianmaharajatours.app.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
