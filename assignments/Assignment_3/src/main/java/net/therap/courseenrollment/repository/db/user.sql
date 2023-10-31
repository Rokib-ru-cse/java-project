CREATE TABLE users
(
    id       serial PRIMARY KEY,
    email    VARCHAR(100),
    password VARCHAR(100),
    role     VARCHAR(30) DEFAULT 'trainee' CHECK (role IN ('admin', 'trainee'))
);