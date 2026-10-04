CREATE TABLE events (
    id UUID PRIMARY KEY,
    venue_id UUID NOT NULL REFERENCES venues(id),
    name VARCHAR(255) NOT NULL,
    description VARCHAR,
    event_start TIMESTAMPTZ NOT NULL,
    booking_start TIMESTAMPTZ NOT NULL,
    booking_end TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL,
    organizer VARCHAR NOT NULL,
    type VARCHAR NOT NULL CHECK (type IN ('ENTERTAINMENT', 'EDUCATIONAL', 'SPORTS', 'OTHER')),
    status VARCHAR NOT NULL CHECK (status IN ('DRAFT', 'PUBLISHED')),
    CHECK (booking_start < booking_end AND booking_end <= event_start)
);