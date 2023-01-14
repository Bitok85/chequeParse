CREATE TABLE IF NOT EXISTS cheque_url (
    id SERIAL PRIMARY KEY,
    c_url TEXT NOT NULL UNIQUE,
    buyer_id INT REFERENCES buyer(id)
);

insert into cheque_url  (c_url, buyer_id) VALUES ('www1', 1) on conflict do nothing;
insert into cheque_url (c_url, buyer_id) VALUES ('www2', 2) on conflict do nothing;
