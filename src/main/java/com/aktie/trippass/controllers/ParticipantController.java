package com.aktie.trippass.controllers;

import com.aktie.trippass.dto.ConfirmParticipantDTO;
import com.aktie.trippass.entities.Participant;
import com.aktie.trippass.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantRepository repository;

    @PostMapping("/confirm")
    public ResponseEntity<Participant> create(@RequestBody ConfirmParticipantDTO dto) {
        Optional<Participant> participant = repository.findByEmailTripId(dto.email(), dto.tripId());

        return participant.map(item -> {
            item.setName(dto.name());
            item.setConfirmed(true);

            repository.save(item);

            return ResponseEntity.ok(item);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> update(@RequestHeader UUID id) {
        Optional<Participant> findedParticipant = repository.findById(id);

        return findedParticipant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
