package com.aktie.mind_journey.controllers;

import com.aktie.mind_journey.dto.InviteTripDTO;
import com.aktie.mind_journey.dto.ParticipantDTO;
import com.aktie.mind_journey.dto.TripDTO;
import com.aktie.mind_journey.entities.Trip;
import com.aktie.mind_journey.repository.TripRepository;
import com.aktie.mind_journey.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private TripRepository repository;

    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody TripDTO dto) {
        Trip trip = new Trip(dto);

        repository.save(trip);

        participantService.registerParticipantsEvent(dto.guestsEmails(), trip);

        return ResponseEntity.ok(trip);
    }

    @GetMapping
    public ResponseEntity<Trip> get(@RequestHeader UUID id) {
        Optional<Trip> findedTrip = repository.findById(id);

        return findedTrip.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestHeader UUID id, @RequestBody TripDTO dto) {
        Optional<Trip> findedTrip = repository.findById(id);

        if (findedTrip.isPresent()) {
            Trip trip = findedTrip.get();

            trip.setStartAt(dto.startAt());
            trip.setEndAt(dto.endAt());
            trip.setDestination(dto.destination());

            repository.save(trip);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestHeader UUID id) {
        Optional<Trip> findedTrip = repository.findById(id);

        return findedTrip.map(trip -> {
                    trip.setConfirmed(true);

                    repository.save(trip);

                    participantService.triggerAllConfirmationEmail(id);

                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/invite")
    public ResponseEntity<?> invite(@RequestHeader UUID id, @RequestBody InviteTripDTO dto) {
        Optional<Trip> findedTrip = repository.findById(id);

        return findedTrip.map(trip -> {
                    participantService.registerParticipantEvent(dto.email(), trip);

                    if (trip.isConfirmed()) {
                        participantService.triggerConfirmationEmail(dto.email());
                    }

                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/participants")
    public ResponseEntity<List<ParticipantDTO>> getAllParticipants(@RequestHeader UUID id) {
        return ResponseEntity.ok(participantService.listByTripId(id));
    }

}
