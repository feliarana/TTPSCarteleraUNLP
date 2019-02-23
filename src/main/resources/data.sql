-- Agregamos los roles
INSERT INTO public.roles(role_name) VALUES('ADMIN');
INSERT INTO public.roles(role_name) VALUES('ALUMNO');
INSERT INTO public.roles(role_name) VALUES('PROFESOR');
-- Agregamos usuarios
INSERT INTO public.users (active, password, username, name, lastname, email, photo) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "admin", "admin", "admin", "a@a.com", "https://www.koolbadges.co.uk/images/thumbnails/i-love-admin-badges-200x200.jpg");
INSERT INTO public.users (active, password, username, name, lastname, email, photo) VALUES (1, '$2a$10$dhqE2Ac0Z.ZKTuzf3I1ugeyESlKYtAIwlt48euY8yTSu8wNxqazXO', "alumno", "Pepe", "Cardenas", "pepe@hotmail.com", "https://assets.trome.pe/files/ec_article_multimedia_gallery/uploads/2018/04/17/5ad609d27c1a7.jpeg");
INSERT INTO public.users (active, password, username, name, lastname, email, photo) VALUES (1, '$2a$10$wzqz/gJMaySr4Vb7LOWx8eMQDt57fy5MuGVqaO1r58HNdcmYX/wd6', "profesor", "Hernecio", "Villarica", "villarica@info.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Belmans_in_labo.jpg/275px-Belmans_in_labo.jpg");
-- Establecemos roles
INSERT INTO public.users_roles(user_id, role_id) VALUES ('1', '1');
INSERT INTO public.users_roles(user_id, role_id) VALUES ('2', '2');
INSERT INTO public.users_roles(user_id, role_id) VALUES ('3', '3');
-- Agregamos carteleras
INSERT INTO public.billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 1ero', 'Los novatos','https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', NULL, '1');
INSERT INTO public.billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 2do', 'Los walleros', 'https://cdn.pixabay.com/photo/2016/06/18/17/42/image-1465348_960_720.jpg', NULL, '1');
INSERT INTO public.billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 3ero', 'Los resistentes', 'https://www.w3schools.com/w3css/img_lights.jpg', NULL, '1');
INSERT INTO public.billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 4to', 'Los tranka', 'https://sample-videos.com/img/Sample-jpg-image-500kb.jpg', NULL, '1');
INSERT INTO public.billboards(created_at, title, description, image, updated_at, user_id) VALUES(CURRENT_TIMESTAMP(), 'Cartelera 5to', 'Los heroes', 'https://www.wonderplugin.com/videos/demo-image0.jpg', NULL, '1');
-- Agregamos publicaciones
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'horarios de primero', 'https://helpx.adobe.com/in/stock/how-to/visual-reverse-image-search/_jcr_content/main-pars/image.img.jpg/visual-reverse-image-search-v2_1000x560.jpg', 'Horarios 1', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'aprobaron casi todos', '', 'Resultados Adp', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'los felicito', '', 'Resultados Arq', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('1', 1, CURRENT_TIMESTAMP(), 'volve en febrero', '', 'Resultados Org', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'si se puede', '', 'Horarios 2', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'acid', '', 'Resultados Ibd', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'muy bien', '', 'Resultados Ing1', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'falto t de n', '', 'Resultados Ayed', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'agarrate con concu', '', 'Horarios 3', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'probabilidades de aprobar', '', 'Resultados Mate 3', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'recursada nro 1920194', '', 'Resultados Redes', NULL, '3');
INSERT INTO public.posts(billboard_id, comments_enabled, created_at, description, image, title, updated_at, user_id) VALUES('2', 1, CURRENT_TIMESTAMP(), 'los mas copados', 'https://wallpaperbrowse.com/media/images/3848765-wallpaper-images-download.jpg', 'Resultados TTPS Java', NULL, '3');
-- Agregamos comentarios
INSERT INTO public.comments(comment, post_id, user_id, created_at) VALUES('Genial! Al fin publican los horarios.', '1', '3', CURRENT_TIMESTAMP());
INSERT INTO public.comments(comment, post_id, user_id, created_at) VALUES('Aprobeeee.', '2', '3', CURRENT_TIMESTAMP());
INSERT INTO public.comments(comment, post_id, user_id, created_at) VALUES('Uh tengo que recursar', '2', '3', CURRENT_TIMESTAMP());
INSERT INTO public.comments(comment, post_id, user_id, created_at) VALUES('APROBAMOS TTPS!!', '1', '3', CURRENT_TIMESTAMP());
-- Agregamos seguidores a carteleras
INSERT INTO public.followed_billboards(user_id, billboard_id) VALUES('1', '1');
INSERT INTO public.followed_billboards(user_id, billboard_id) VALUES('1', '2');
INSERT INTO public.followed_billboards(user_id, billboard_id) VALUES('1', '3');
INSERT INTO public.followed_billboards(user_id, billboard_id) VALUES('1', '4');
