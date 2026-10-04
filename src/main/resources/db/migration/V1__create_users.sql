CREATE TABLE users (
    id UUID PRIMARY KEY,
    password_hash VARCHAR(255) NOT NULL,
    name VARCHAR NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    phone VARCHAR,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL,
    role VARCHAR NOT NULL CHECK (role IN ('BOOKER', 'ADMIN')),
    gender VARCHAR CHECK (gender IN ('MALE', 'FEMALE', 'OTHER')),
    status VARCHAR NOT NULL CHECK (status IN ('ACTIVE', 'INACTIVE', 'DELETED'))
);