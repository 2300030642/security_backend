package com.klef.controller;

import com.klef.entity.PasswordRequest;
import com.klef.entity.PasswordResponse;
import com.klef.service.PasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/check")
    public PasswordResponse checkPassword(@RequestBody PasswordRequest request) {

        String strength = passwordService.checkStrength(request.getPassword());
        String suggestion = passwordService.getSuggestion(request.getPassword());

        return new PasswordResponse(strength, suggestion);
    }
}
