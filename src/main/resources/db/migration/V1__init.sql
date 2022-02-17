CREATE TABLE product(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    buy_price INTEGER NOT NULL,
    count_for_one INTEGER NOT NULL,
    count_type TEXT NOT NULL
);

CREATE TABLE warehouse(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    address TEXT NOT NULL
);

CREATE TABLE warehouse_product_hold (
    warehouse_id BIGINT REFERENCES warehouse  (id),
    product_id BIGINT REFERENCES product  (id),
    count DOUBLE PRECISION NOT NULL,
    count_type TEXT NOT NULL
);

CREATE TABLE warehouse_logbook(
    id BIGSERIAL PRIMARY KEY,
    warehouse_id BIGINT REFERENCES warehouse  (id),
    product_id BIGINT REFERENCES product  (id),
    count DOUBLE PRECISION NOT NULL,
    transaction_time TIMESTAMP
);