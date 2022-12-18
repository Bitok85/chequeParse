CREATE TABLE IF NOT EXISTS cheque_urls (
    c_url TEXT NOT NULL UNIQUE,
    data JSONB,
    buyer_id INT REFERENCES buyer(id)
)

