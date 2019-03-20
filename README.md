# InfoCarte
###### Cartelera virtual enfocada a organizaciones universitarias.


POST: api/auth/signup (admin)

POST: billboards (admin)

DELETE: billboards/1 (admin)

PATCH: users/1

PATCH: billboards/1 (admin, profesor)

POST: posts (admin, profesor)

POST: comments (admin, alumno, profesor)

POST: api/auth/signin (admin, alumno, profesor)

GET: users/ (publico)

GET: users/1 (publico)

GET: billboards/ (publico)

GET: billboards/1 (publico)

GET: users/check_username_availability?username=a@a (publico)

GET: users/2/comments

GET: users/2/followedBillboards

GET: billboards/1/usersFollowers

GET: comments

GET: permissions

GET: users/6/permissions

GET: users/1/userNotifications/1

DELETE: permission/billboard/1/user/6

DELETE: posts/1

DELETE: users/2/followBillboard

DELETE: billboards/1

La aplicación tarda un poco la primera vez en cargarse porque tiene que inicializar la aplicación de Spring (la api rest) en heroku.

Como la aplicación que está alojada en Heroku es usando el servicio gratuito, si el dyno no recibe tráfico durante 30 minutos, se podrá a dormir, por lo tanto luego de ese tiempo si se accede nuevamente, la aplicacion debera volver a iniciarse entonces tardará nuevamente en arrancar ya que tiene que volver a inicializar todo desde cero.
En todo momento se puede ir al home de la aplicación haciendo click en la palabra “Infocarte” que se encuentra en la barra de navegación.

Tal como dice el enunciado, los alumnos son los únicos que pueden seguir carteleras, por lo tanto son los únicos que pueden recibir notificaciones.

Tanto los administradores, como los docentes y los alumnos pueden comentar publicaciones, siempre y cuando la publicación tenga los comentarios habilitados.

Tanto los administradores como los profesores pueden ver los seguidores de cada cartelera. Los alumnos no pueden realizar esta acción.

Tal como dice el enunciado, los profesores pueden crear publicaciones en las carteleras que tengan permiso. No pueden crear carteleras, esa acción solo la puede realizar el administrador.

Los administradores pueden crear, editar y eliminar todas las carteleras y publicaciones del sistema. Lo que no pueden eliminar son los comentarios de otros usuarios.

El acceso a las vistas para realizar las acciones de crear publicaciones y administrar los permisos de los profesores sobre las carteleras solo pueden realizarse dentro de una cartelera.

En la sección de “publicaciones creadas” que es accesible por los administradores y profesores, cada publicación tiene un enlace hacia su cartelera para que el usuario pueda ver a que cartelera pertenece, ya que las publicaciones mostradas pueden ser de cualquiera de las carteleras.

Todas las carteleras y publicaciones del sistema poseen una imágen. Al momento de crear una cartelera o publicación seleccionar una imagen es opcional, pero en el caso de no incluirla se asignará una por defecto.
Se utilizó Firebase como servidor de alojamiento de imágenes.

Todos los usuarios del sistema ya existen al inicializarlo. No se puede crear, editar ni eliminar usuarios ya que el enunciado no lo contempla. Los profesores y alumnos supuestamente ya existen en Siu Guaraní.
