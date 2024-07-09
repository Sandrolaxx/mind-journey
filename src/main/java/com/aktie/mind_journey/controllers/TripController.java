package com.aktie.mind_journey.controllers;

import com.aktie.mind_journey.CreateTripDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripController {

    public ResponseEntity<String> create(@RequestBody CreateTripDTO) {

    }

}
