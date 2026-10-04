CREATE TABLE payments (
    id UUID PRIMARY KEY,
    booking_id UUID NOT NULL REFERENCES bookings(id),
    status VARCHAR NOT NULL CHECK (status IN ('PENDING', 'SUCCESS', 'FAILED', 'TIMEOUT', 'REFUNDED')),
    amount NUMERIC(10,2) NOT NULL CHECK (amount >= 0),
    transaction_id VARCHAR,
    payment_method VARCHAR,
    idempotency_key VARCHAR NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL
);