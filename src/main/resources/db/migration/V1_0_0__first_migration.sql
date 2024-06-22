CREATE schema if not exists circledev;

CREATE TABLE  circledev.product (
        product_id UUID PRIMARY KEY,
        title VARCHAR(30) NOT NULL,
        description VARCHAR(200) NOT NULL,
        timestamp timestamptz DEFAULT CURRENT_TIMESTAMP

);

CREATE TABLE  circledev.order (
        order_id UUID PRIMARY KEY,
        order_date DATE CHECK (order_date <= CURRENT_DATE),
                                  region VARCHAR(255)
);
CREATE TABLE circledev.OrderProduct (
            order_id UUID,
            product_id UUID,
            PRIMARY KEY (order_id, product_id),
            FOREIGN KEY (order_id) REFERENCES circledev.order(order_id),
            FOREIGN KEY (product_id) REFERENCES circledev.product(product_id),
            FOREIGN KEY (product_id) REFERENCES circledev.product(product_id)
);

CREATE OR REPLACE FUNCTION set_timestamp()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.timestamp = now();
RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_timestamp
    BEFORE INSERT ON product
    FOR EACH ROW
    EXECUTE FUNCTION set_timestamp();

