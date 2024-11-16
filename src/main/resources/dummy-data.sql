-- Insert data into Customer table
INSERT INTO tbl_customer (name, email, created_at, updated_at) VALUES
    ('John Doe', 'john.doe@example.com', '2024-01-01 10:00:00', '2024-01-01 10:00:00'),
    ('Jane Roe', 'jane.roe@example.com', '2024-01-02 11:00:00', '2024-01-02 11:00:00'),
    ('Alice Smith', 'alice.smith@example.com', '2024-01-03 12:00:00', '2024-01-03 12:00:00'),
    ('Bob Brown', 'bob.brown@example.com', '2024-01-04 13:00:00', '2024-01-04 13:00:00');

-- Insert data into Customer_Order table
INSERT INTO tbl_order (customer_id, amount, order_date, created_at, updated_at) VALUES
    (1, 150.00, '2024-05-15 14:30:00', '2024-05-15 14:30:00', '2024-05-15 14:30:00'),
    (1, 50.00, '2024-05-20 15:00:00', '2024-05-20 15:00:00', '2024-05-20 15:00:00'),
    (2, 200.00, '2024-05-25 16:00:00', '2024-05-25 16:00:00', '2024-05-25 16:00:00'),
    (2, 300.00, '2024-06-10 17:00:00', '2024-06-10 17:00:00', '2024-06-10 17:00:00'),
    (3, 400.00, '2024-06-15 18:00:00', '2024-06-15 18:00:00', '2024-06-15 18:00:00'),
    (3, 120.00, '2024-06-20 19:00:00', '2024-06-20 19:00:00', '2024-06-20 19:00:00'),
    (4, 250.00, '2024-07-01 10:30:00', '2024-07-01 10:30:00', '2024-07-01 10:30:00'),
    (4, 100.00, '2024-07-05 11:00:00', '2024-07-05 11:00:00', '2024-07-05 11:00:00');
