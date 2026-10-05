package com.prashu.event_management.notification.entity;

import com.prashu.event_management.booking.entity.Booking;
import com.prashu.event_management.user.entity.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(nullable = false)
    private String msg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationTypeEnum type;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    public Notification() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NotificationStatusEnum getStatus() {
        return status;
    }

    public void setStatus(NotificationStatusEnum status) {
        this.status = status;
    }

    public NotificationTypeEnum getType() {
        return type;
    }

    public void setType(NotificationTypeEnum type) {
        this.type = type;
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
}