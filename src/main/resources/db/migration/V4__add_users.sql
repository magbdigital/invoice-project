CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    locked BOOLEAN,
    disabled BOOLEAN,
    PRIMARY KEY (id),
    UNIQUE (email),
    UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS role (
    id SERIAL,
    role VARCHAR(100) NOT NULL,
    user_id INT,
    PRIMARY KEY (id)
);