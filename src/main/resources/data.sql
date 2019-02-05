-- Agregamos los roles
INSERT INTO roles(role_name) VALUES('ROLE_ADMIN');
INSERT INTO roles(role_name) VALUES('ROLE_ALUMNO');
INSERT INTO roles(role_name) VALUES('ROLE_PROFESOR');
-- Agregamos usuarios
INSERT INTO users (active, password, username) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "admin");
INSERT INTO users (active, password, username) VALUES (1, '$2a$10$dhqE2Ac0Z.ZKTuzf3I1ugeyESlKYtAIwlt48euY8yTSu8wNxqazXO', "alumno");
INSERT INTO users (active, password, username) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "profesor");
-- Establecemos roles
INSERT INTO users_roles(user_id, role_id) VALUES ('1', '1');
INSERT INTO users_roles(user_id, role_id) VALUES ('11', '11');
INSERT INTO users_roles(user_id, role_id) VALUES ('21', '21');
-- Agregamos carteleras
INSERT INTO billboards(created_at, title, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 1ero', NULL, '1');
INSERT INTO billboards(created_at, title, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 2do', NULL, '1');
INSERT INTO billboards(created_at, title, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 3ero', NULL, '1');
INSERT INTO billboards(created_at, title, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 4to', NULL, '1');
INSERT INTO billboards(created_at, title, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 5to', NULL, '1');
-- Agregamos publicaciones
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'Horarios 1', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'Resultados Adp', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'Resultados Arq', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'Resultados Org', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'Horarios 2', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'Resultados Ibd', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'Resultados Ing1', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'Resultados Ayed', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'Horarios 3', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'Resultados Mate 3', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'Resultados Redes', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'Resultados TTPS Java', NULL, '21');
-- Agregamos comentarios
INSERT INTO comments(content, post_id, user_id) VALUES('Genial! Al fin publican los horarios.', '11', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('Aprobeeee.', '21', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('Uh tengo que recursar', '21', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('APROBAMOS TTPS!!', '1', '11');
-- Agregamos seguidores a carteleras
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '1');
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '11');
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '41');
