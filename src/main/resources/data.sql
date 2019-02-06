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
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 1ero', 'Los novatos','https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', NULL, '1');
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 2do', 'Los walleros', 'https://cdn.pixabay.com/photo/2016/06/18/17/42/image-1465348_960_720.jpg', NULL, '1');
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 3ero', 'Los resistentes', 'https://www.w3schools.com/w3css/img_lights.jpg', NULL, '1');
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 4to', 'Los tranka', 'https://sample-videos.com/img/Sample-jpg-image-500kb.jpg', NULL, '1');
INSERT INTO billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 5to', 'Los heroes', 'https://www.wonderplugin.com/videos/demo-image0.jpg', NULL, '1');
-- Agregamos publicaciones
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'horarios de primero', 'https://helpx.adobe.com/in/stock/how-to/visual-reverse-image-search/_jcr_content/main-pars/image.img.jpg/visual-reverse-image-search-v2_1000x560.jpg', 'Horarios 1', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'aprobaron casi todos', '', 'Resultados Adp', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'los felicito', '', 'Resultados Arq', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'volve en febrero', '', 'Resultados Org', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'si se puede', '', 'Horarios 2', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'acid', '', 'Resultados Ibd', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'muy bien', '', 'Resultados Ing1', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('11', 1, CURRENT_TIMESTAMP(), 'falto t de n', '', 'Resultados Ayed', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'agarrate con concu', '', 'Horarios 3', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'probabilidades de aprobar', '', 'Resultados Mate 3', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'recursada nro 1920194', '', 'Resultados Redes', NULL, '21');
INSERT INTO posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('21', 1, CURRENT_TIMESTAMP(), 'los mas copados', 'https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg', 'Resultados TTPS Java', NULL, '21');
-- Agregamos comentarios
INSERT INTO comments(content, post_id, user_id) VALUES('Genial! Al fin publican los horarios.', '11', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('Aprobeeee.', '21', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('Uh tengo que recursar', '21', '11');
INSERT INTO comments(content, post_id, user_id) VALUES('APROBAMOS TTPS!!', '1', '11');
-- Agregamos seguidores a carteleras
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '1');
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '11');
INSERT INTO followed_billboards(user_id, billboard_id) VALUES('11', '41');
