/*datos tabla ROL*/

INSERT INTO rol( id, nombre)  VALUES (1, 'administrador');
INSERT INTO rol( id, nombre)  VALUES (2, 'transaccional');

/*datos tabla USUARIO*/
INSERT INTO usuario(  id, enabled, password, username)  VALUES (1, true, '$2a$10$8.0zk9BHB2F3y0KNCpRMKuFxOFZi3DFU.5X6VRy8m/b/sb2BHfyIq', 'diego');
INSERT INTO usuario(  id, enabled, password, username)  VALUES (2, true, '$2a$10$thbkk15CAFhTFf6ZzYBfMOAUe3nSkjq6Ebu5990F95JmUwkyZv60u', 'anonimo');

/*datos tabla USUARIO_ROL*/
INSERT INTO usuario_rol( user_id, rol_id)  VALUES (1, 1);
INSERT INTO usuario_rol( user_id, rol_id)  VALUES (2, 2);
