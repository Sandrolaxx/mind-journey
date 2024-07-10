package com.aktie.mind_journey.entities;

import com.aktie.mind_journey.dto.CreateTripDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "AKT_TRIP")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "DESTINATION", nullable = false)
    private String destination;

    @Column(name = "START_AT", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "END_AT", nullable = false)
    private LocalDateTime endAt;

    @Column(name = "CONFIRMED")
    private boolean confirmed;

    @Column(name = "OWNER_NAME", nullable = false)
    private String ownerName;

    @Column(name = "OWNER_EMAIL", nullable = false)
    private String ownerEmail;

    public Trip() {
    }

    public Trip(CreateTripDTO dto) {
        this.destination = dto.destination();
        this.confirmed = false;
        this.ownerName = dto.ownerName();
        this.ownerEmail = dto.ownerEmail();
        this.startAt = dto.startAt();
        this.endAt = dto.endAt();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

}
