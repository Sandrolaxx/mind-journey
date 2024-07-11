package com.aktie.trippass.entities;

import com.aktie.trippass.dto.LinkDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "AKT_LINK")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "TRIP_ID", nullable = false)
    private Trip trip;

    public Link() {
    }

    public Link(LinkDTO dto, Trip trip) {
        this.title = dto.title();
        this.url = dto.url();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}

