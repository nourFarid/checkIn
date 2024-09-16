package com.artlanguage.checkIn.controller;

import com.artlanguage.checkIn.DTO.CheckInRequest;
import com.artlanguage.checkIn.DTO.UsersDTO;
import com.artlanguage.checkIn.DTO.UsersResponseDTO;
import com.artlanguage.checkIn.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @PostMapping("/checkin")
    public ResponseEntity<?> createCheckIn(@RequestBody CheckInRequest checkInRequest) {
        return ResponseEntity.ok(checkInService.checkIn(checkInRequest));
    }
}
