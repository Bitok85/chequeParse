CREATE TABLE IF NOT EXISTS buyer (
    id SERIAL PRIMARY KEY,
    tg_name TEXT NOT NULL UNIQUE,
    email TEXT,
    status TEXT
)