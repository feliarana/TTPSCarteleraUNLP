-- Agregamos los roles
INSERT INTO roles(id, role_name) VALUES(1,'ROLE_ADMIN');
INSERT INTO roles(id, role_name) VALUES(2,'ROLE_USER');
-- Agregamos al usuario Admin, que tiene los roles de admin y usuario comun.
INSERT INTO users (id, active, password, username) VALUES (1, 1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "admin");
-- INSERT INTO users_roles(user_id, role_id) VALUES ('1', '1');
-- INSERT INTO users_roles(user_id, roles_id) VALUES ('1', '2');
