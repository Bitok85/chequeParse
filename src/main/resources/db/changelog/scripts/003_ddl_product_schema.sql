CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    price_first DECIMAL(10, 2),
    price_last DECIMAL(10, 2),
    buyer_id INT REFERENCES buyer(id)
);


insert into product (name, price_first, price_last, buyer_id) VALUES ('product1', 33.22, 38.45, 1) on conflict do nothing;
insert into product (name, price_first, price_last, buyer_id) VALUES ('product2', 55.22, 75.45, 2) on conflict do nothing;

