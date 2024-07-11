package com.aktie.trippass.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "AKT_PARTICIPANT")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CONFIRMED")
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private Trip trip;

    public Participant() {
    }

    public Participant(String email, Trip trip) {
        this.email = email;
        this.trip = trip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}

