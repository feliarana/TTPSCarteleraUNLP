-- Agregamos los roles
INSERT INTO roles(role_name) VALUES('ADMIN');
INSERT INTO roles(role_name) VALUES('ALUMNO');
INSERT INTO roles(role_name) VALUES('PROFESOR');
-- Agregamos usuarios
INSERT INTO users (active, password, username, name, lastname) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "admin", "admin", "admin");
INSERT INTO users (active, password, username, name, lastname) VALUES (1, '$2a$10$dhqE2Ac0Z.ZKTuzf3I1ugeyESlKYtAIwlt48euY8yTSu8wNxqazXO', "alumno", "Pepe", "Cardenas");
INSERT INTO users (active, password, username, name, lastname) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "profesor", "Hernecio", "Villarica");
-- Establecemos roles
INSERT INTO users_roles(user_id, role_id) VALUES ('1', '1');

-- Agregamos carteleras
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 1ero', 'Los novatos','https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', NULL, '1');

-- Agregamos publicaciones
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'horarios de primero', 'https://helpx.adobe.com/in/stock/how-to/visual-reverse-image-search/_jcr_content/main-pars/image.img.jpg/visual-reverse-image-search-v2_1000x560.jpg', 'Horarios 1', NULL, '1');
-- Agregamos comentarios
INSERT INTO comments(comment, post_id, user_id) VALUES('Genial! Al fin publican los horarios.', '1', '1');

-- Agregamos seguidores a carteleras
