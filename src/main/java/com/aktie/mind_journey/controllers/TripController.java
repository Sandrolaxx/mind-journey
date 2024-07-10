package com.aktie.mind_journey.controllers;

import com.aktie.mind_journey.dto.CreateTripDTO;
import com.aktie.mind_journey.entities.Trip;
import com.aktie.mind_journey.repository.TripRepository;
import com.aktie.mind_journey.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private TripRepository repository;

    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody CreateTripDTO dto) {
        Trip trip = new Trip(dto);

        repository.save(trip);

        participantService.registerParticipantsEvent(dto.guestsEmails(), trip.getId());

        return ResponseEntity.ok(trip);
    }

}
