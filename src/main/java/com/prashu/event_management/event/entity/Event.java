package com.prashu.event_management.event.entity;


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

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organizer;

    @Column
    private String description;

    @Column(nullable = false)
    private Instant eventStart;

    @Column(nullable = false)
    private Instant bookingStart;

    @Column(nullable = false)
    private Instant bookingEnd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventTypeEnum type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventStatusEnum status;

    public Event() {
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getEventStart() {
        return eventStart;
    }

    public void setEventStart(Instant eventStart) {
        this.eventStart = eventStart;
    }

    public Instant getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Instant bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Instant getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Instant bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public EventTypeEnum getType() {
        return type;
    }

    public void setType(EventTypeEnum type) {
        this.type = type;
    }

    public EventStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EventStatusEnum status) {
        this.status = status;
    }
}
