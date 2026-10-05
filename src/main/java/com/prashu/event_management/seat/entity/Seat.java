package com.prashu.event_management.seat.entity;

import com.prashu.event_management.venue.entity.Venue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.UUID;

@Entity
@Table(name = "seats", uniqueConstraints = @UniqueConstraint(columnNames = {"venue_id", "label"}))
public class Seat {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY) // This is Eager by default -> will always load venue w seats -> over-fetching
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatTypeEnum type;

    @Column(nullable = false)
    private String label;

    public Seat() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public SeatTypeEnum getType() {
        return type;
    }

    public void setType(SeatTypeEnum type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
