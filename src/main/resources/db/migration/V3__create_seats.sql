CREATE TABLE seats (
    id UUID PRIMARY KEY,
    venue_id UUID NOT NULL REFERENCES venues(id),
    type VARCHAR NOT NULL CHECK (type IN ('GOLD', 'SILVER', 'VIP')),
    label VARCHAR NOT NULL,
    UNIQUE (venue_id, label)
);