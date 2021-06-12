/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Ojos', 'delaventa', 'ojos@gmail.com', '2019-09-05', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Gris', 'Rata', 'grisrata@gmail.com', '2019-10-07', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Valdo', 'trotamundos', 'valdo@gmail.com', '2019-11-03', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Toby', 'Doe', 'Toby@gmail.com', '2019-12-04', '');
INSERT INTO clientes (nombre, apellido, email, create_at, foto) VALUES('Cuco', 'deltortas', 'cuco.@gmail.com', '2020-01-05', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Metal Ceramico Coronas Totales', 240, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Metal Ceramico Incrustaciones', 210, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Metal Ceramico Coronas 3/4', 210, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Metal Ceramico Coronas Venner', 270, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Metal Ceramico Pivotes', 130, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('NPG Coronas totales', 250, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('NPG Incrustaciones', 220, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Incrustaciones', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Ceramica', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('juancarlos','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);



INSERT INTO `authorities` (id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (id, authority) VALUES (3,'ROLE_INVITADO');

INSERT `usuario_role` (idusers, idauthorities) VALUES (1,1);
INSERT `usuario_role` (idusers, idauthorities) VALUES (2,2);

