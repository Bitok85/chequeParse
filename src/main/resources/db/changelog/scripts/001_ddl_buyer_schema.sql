CREATE TABLE IF NOT EXISTS buyer (
    id SERIAL PRIMARY KEY,
    tg_name TEXT NOT NULL UNIQUE,
    email TEXT
);

insert into buyer (tg_name, email) VALUES ('test1', '@rambler') on conflict do nothing;
insert into buyer (tg_name, email) VALUES ('test2', '@rambler') on conflict do nothing;