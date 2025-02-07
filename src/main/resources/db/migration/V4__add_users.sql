CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL,
    username VARCHAR(20)  NOT NULL,
    password VARCHAR(200) NOT NULL,
    email    VARCHAR(50)  NOT NULL,
    locked   BOOLEAN      NOT NULL,
    disabled BOOLEAN      NOT NULL,
    UNIQUE (username),
    UNIQUE (email),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS role
(
    id      SERIAL,
    role    VARCHAR(25) NOT NULL,
    user_id INTEGER     NOT NULL,
    UNIQUE (role, user_id),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE permission
(
    id            SERIAL ,
    resource_path VARCHAR(255) NOT NULL,
    http_method   VARCHAR(10)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role_permission
(
    role_id       INT,
    permission_id INT,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)
);