package com.aktie.trippass.entities;

import com.aktie.trippass.dto.ActivityDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "AKT_ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private Trip trip;

    public Activity() {
    }

    public Activity(ActivityDTO dto, Trip trip) {
        this.title = dto.title();
        this.date = dto.date();
        this.trip = trip;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}

