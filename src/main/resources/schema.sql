CREATE TABLE IF NOT EXISTS tbl_customer (
       id SERIAL PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) UNIQUE NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       CONSTRAINT email_format CHECK (email ~* '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$')
);

COMMENT ON TABLE  tbl_customer IS 'Stores information about customers';
COMMENT ON COLUMN tbl_customer.id IS 'Primary key for the customer table';
COMMENT ON COLUMN tbl_customer.name IS 'Name of the customer';
COMMENT ON COLUMN tbl_customer.email IS 'Unique email address of the customer';
COMMENT ON COLUMN tbl_customer.created_at IS 'Timestamp when the customer was added to the system';
COMMENT ON COLUMN tbl_customer.updated_at IS 'Timestamp of the most recent update to the customer record';

CREATE TABLE IF NOT EXISTS tbl_order (
       id SERIAL PRIMARY KEY,
       customer_id INT NOT NULL,
       amount NUMERIC(10, 2) NOT NULL CHECK (amount > 0),
       order_date TIMESTAMP NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (customer_id) REFERENCES tbl_customer (id) ON DELETE CASCADE
);

COMMENT ON TABLE  tbl_order IS 'Stores information about orders placed by customers';
COMMENT ON COLUMN tbl_order.id IS 'Primary key for the customer_order table';
COMMENT ON COLUMN tbl_order.customer_id IS 'Foreign key referencing the customer who placed the order';
COMMENT ON COLUMN tbl_order.amount IS 'Total value of the order';
COMMENT ON COLUMN tbl_order.order_date IS 'Date and time when the order was placed';
COMMENT ON COLUMN tbl_order.created_at IS 'Timestamp when the order was created';
COMMENT ON COLUMN tbl_order.updated_at IS 'Timestamp of the most recent update to the order record';