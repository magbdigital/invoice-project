# invoice-project

Ejecutar este codigo en la base de datos para crear usuario y role
el password encriptado  es: admin
```
INSERT INTO users (username, password, email, locked, disabled)
VALUES ('jdoe', '$2a$12$Qy1nYzJw/b/qQQ3HHxGbYehy/VSeXcRPjK80n9fDEPE7bMctXrGlK', 'jdoe@example.com', FALSE, FALSE);

INSERT INTO role (role, user_id)
VALUES ('ADMIN', 1);
```