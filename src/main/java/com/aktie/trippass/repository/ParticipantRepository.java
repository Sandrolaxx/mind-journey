package com.aktie.trippass.repository;

import com.aktie.trippass.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    @Query("SELECT p FROM Participant p WHERE p.email = ?1 AND p.trip.id = ?2")
    Optional<Participant> findByEmailTripId(String email, UUID tripId);

    List<Participant> findByTripId(UUID tripId);

}
