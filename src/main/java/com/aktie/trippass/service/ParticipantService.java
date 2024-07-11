package com.aktie.trippass.service;

import com.aktie.trippass.dto.ParticipantDTO;
import com.aktie.trippass.entities.Participant;
import com.aktie.trippass.entities.Trip;
import com.aktie.trippass.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public List<ParticipantDTO> listByTripId(UUID tripId) {
        return repository.findByTripId(tripId).stream()
                .map(item -> new ParticipantDTO(item.getId(), item.getName(), item.getEmail(), item.isConfirmed()))
                .toList();
    }

    public void registerParticipantsEvent(List<String> emailsToInvite, Trip trip) {
        var participants = emailsToInvite.stream()
                .map(email -> new Participant(email, trip))
                .toList();

        repository.saveAll(participants);
    }

    public void registerParticipantEvent(String email, Trip trip) {
        repository.save(new Participant(email, trip));
    }

    public void triggerAllConfirmationEmail(UUID tripId) {

    }

    public void triggerConfirmationEmail(String email) {

    }


}
