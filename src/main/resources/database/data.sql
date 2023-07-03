-- Inserting data into the Artist table
INSERT INTO artists(stage_name, full_name, created_date)
VALUES ('Wizkid', 'Ayo Balogun', '2023-05-10T15:30:00'),
       ('Davido', 'David Adeleke', '2023-05-10T15:30:00'),
       ('Burna Boy', 'Damini Ogulu', '2023-05-10T15:30:00');

INSERT INTO users (username, email, balance, created_date)
VALUES ('john_doe', 'john.doe@example.com', 1000.00, '2023-05-10T15:30:00'),
       ('jane_smith', 'jane.smith@example.com', 500.00, '2023-05-10T15:30:00'),
       ('mark_johnson', 'mark.johnson@example.com', 1500.00, '2023-05-10T15:30:00');

-- Inserting data into the Project table
INSERT INTO projects (project_name, artist_id, target_amount, project_status, created_date)
VALUES ('Naija Made', 1, 100000000.00, 'APPROVED', '2023-07-02T15:30:00'),
       ('Ghana Made', 2, 100000000.00, 'APPROVED', '2023-07-02T15:30:00');

INSERT INTO tokens (token_name, token_value, project_id, created_date)
VALUES ('Token 1', 1000.00, 1, '2023-07-02T15:30:00'),
       ('Token 2', 500.00, 2, '2023-07-02T15:30:00');

INSERT INTO transactions (transaction_status, transaction_amount, transaction_type, transaction_date, user_id, token_id,
                          created_date)
VALUES ('SUCCESSFUL', 500.00, 'PURCHASE', '2022-01-01 10:00:00', 1, 1, '2023-05-10T15:30:00'),
       ('SUCCESSFUL', 300.00, 'PURCHASE', '2022-02-15 14:30:00', 2, 1, '2023-05-10T15:30:00'),
       ('SUCCESSFUL', 800.00, 'PURCHASE', '2022-03-20 16:45:00', 1, 2, '2023-05-10T15:30:00'),
       ('SUCCESSFUL', 35000.00, 'PURCHASE', '2022-03-20 16:45:00', 2, 2, '2023-05-10T15:30:00'),
       ('SUCCESSFUL', 735000.00, 'PURCHASE', '2022-03-20 16:45:00', 2, 2, '2023-05-10T15:30:00');

INSERT INTO investments (user_id, token_id, investment_amount, investment_date, created_date)
VALUES (1, 1, 1000.00, '2022-05-01 10:30:00', '2023-07-02T15:30:00'),
       (2, 1, 1500.00, '2022-05-02 14:45:00', '2023-07-02T15:30:00'),
       (1, 2, 2000.00, '2022-05-03 09:15:00', '2023-07-02T15:30:00'),
       (3, 1, 500.00, '2022-05-04 16:20:00', '2023-07-02T15:30:00');






