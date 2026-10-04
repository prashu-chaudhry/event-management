CREATE TABLE event_seats (
    id UUID PRIMARY KEY,
    seat_id UUID NOT NULL REFERENCES seats(id),
    event_id UUID NOT NULL REFERENCES events(id),
    status VARCHAR NOT NULL CHECK (status IN ('AVAILABLE', 'RESERVED', 'SOLD')),
    version INTEGER NOT NULL DEFAULT 0,
    price NUMERIC(10,2) NOT NULL CHECK (price >= 0),
    booking_id UUID REFERENCES bookings(id),
    UNIQUE (event_id, seat_id)
);