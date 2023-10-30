INSERT INTO users (name, email, gender, status)
VALUES 
  ('Nombre del Usuario', 'correo@example.com', 'Masculino', 'Activo'),
  ('Nombre del Usuario2', 'correo2@example.com', 'Masculino', 'Activo'),
  ('Richard','richard.sivila.rios@gmail.com','masculino','active');

INSERT INTO "public".roles (id_rol,cod_estado, nombre)
VALUES 
  (1,1, 'Administrador'),
  (2,1, 'Técnico'),
  (3,1, 'Supervisor'),
  (4,1, 'Usuario'),
  (5,1,'Observador');

-- Insertar datos en la tabla "public".personas

INSERT INTO "public".personas (seq_persona, apellido_materno, apellido_paterno, cedula_identidad, cod_estado, cod_tipo, fotografia, nombres, telefono_celular)
VALUES 
  (1,'Pérez', 'González', '9876543210', 1, 'A', 'foto.jpg', 'Ana', '555-555-5556'),
  (2,'Rodríguez', 'Fernández', '5678901234', 1, 'A', 'foto.jpg', 'Pedro', '555-555-5557'),
  (3,'Martínez', 'López', '2345678901', 1, 'A', 'foto.jpg', 'María', '555-555-5558'),
  (4,'García', 'Hernández', '1234567890', 1, 'A', 'foto.jpg', 'Luis', '555-555-5559'),
  (5,'Sánchez', 'Ramírez', '3456789012', 1, 'A', 'foto.jpg', 'Elena', '555-555-5560'),
  (6,'Sivila', 'Rios', '4143805', 1, 'A', 'foto.jpg', 'mario', '67382875');

-- Insertar datos en la tabla "public".usuarios

INSERT INTO "public".usuarios (codu,cod_estado, usuario, contrasena, seq_persona)
VALUES 
  (1,1, 'admin', 'admin', 1),
  (2,1, 'tecnico1', 'tecnico1', 2),
  (3,1, 'supervisor1', 'supervisor1', 3),
  (4,1, 'usuario1', 'usuario1', 4),
  (5,1, 'usuario2', 'usuario2', 5),
  (6,1, 'usuario3', 'usuario3', 6);


-- Insertar datos en la tabla "public".usuario_roles
INSERT INTO "public".usuario_roles (id_rol, usuario)
VALUES 
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4);

-- Insertar datos en la tabla "public".solicitudes_servicio
INSERT INTO "public".solicitudes_servicio (seq_solicitud_servicio, cod_estado, descripcion_problema, fecha, seq_persona_solicita)
VALUES 
  (1,1, 'Problema en la computadora', '2023-09-25', 1),
  (2,1, 'Servidor caído', '2023-09-26', 2),
  (3,1, 'Laptop no enciende', '2023-09-27', 3),
  (4,1, 'Teclado dañado', '2023-09-28', 4),
  (5, 1, 'Problemas de red', '2023-09-29', 5);

-- Insertar datos en la tabla "public".procesos

INSERT INTO "public".procesos (codp,enlace, estado, nombre)
VALUES 
  (1,'enlace1', 1, 'Proceso 1'),
  (2,'enlace2', 1, 'Proceso 2'),
  (3,'enlace3', 1, 'Proceso 3'),
  (4,'enlace4', 1, 'Proceso 4'),
  (5, 'enlace5', 1, 'Proceso 5');

-- Insertar datos en la tabla "public".menus

INSERT INTO "public".menus (codm,estado, nombre)
VALUES 
  (1,1, 'Inicio'),
  (2,1, 'Configuración'),
  (3,1, 'Mantenimiento'),
  (4,1, 'Informes'),
  (5, 1, 'Usuarios');


-- Insertar datos en la tabla "public".mepro
INSERT INTO "public".mepro (codp, codm)
VALUES 
  (1, 1),
  (2, 1),
  (3, 2),
  (4, 3);
  
-- Insertar datos en la tabla "public".rolme 
INSERT INTO "public".rolme (codr,codm) 
VALUES 
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (4,5);

-- Insertar datos en la tabla "public".fallas
INSERT INTO "public".fallas (id_falla, cod_estado, nombre)
VALUES 
  (1, 1, 'Pantalla rota'),
  (2, 1, 'Problema de alimentación'),
  (3, 1, 'Disco duro defectuoso'),
  (4, 1, 'Teclado dañado'),
  (5, 1, 'Problemas de red');


-- Insertar datos en la tabla "public".activo

INSERT INTO "public".activo (seq_activo, cod_estado, comentarios, id_etiqueta_fisica, marca, modelo, nombre)
VALUES 
  (1,1, 'Computadora de prueba 1', 'ETIQ001', 'Dell', 'Inspiron', 'Computadora 1'),
  (2,1, 'Computadora de prueba 2', 'ETIQ002', 'HP', 'Pavilion', 'Computadora 2'),
  (3,1, 'Laptop de trabajo', 'ETIQ003', 'Lenovo', 'ThinkPad', 'Laptop 1'),
  (4,1, 'Servidor de base de datos', 'ETIQ004', 'HP', 'ProLiant', 'Servidor 1'),
  (5,1, 'Computadora de oficina', 'ETIQ005', 'Acer', 'Aspire', 'Computadora 3');

-- Insertar datos en la tabla "public".ordenes_trabajo
INSERT INTO "public".ordenes_trabajo (seq_orden_trabajo, cod_atendido, cod_estado, cod_tipo_mantenimiento, fecha_emision, numero_orden_trabajo, ubicacion_activo, seq_persona_planificante, seq_solicitud_servicio)
VALUES 
  (1, 0, 1, 'CM', '2023-09-25', 'OT-001', 'Oficina 1', 1, 1),
  (2, 0, 1, 'CM', '2023-09-26', 'OT-002', 'Sala de servidores', 2, 2),
  (3, 0, 1, 'CM', '2023-09-27', 'OT-003', 'Oficina 2', 3, 3),
  (4, 0, 1, 'CM', '2023-09-28', 'OT-004', 'Oficina 3', 4, 4),
  (5, 0, 1, 'CM', '2023-09-29', 'OT-005', 'Oficina 4', 5, 5);

-- Insertar datos en la tabla "public".recepciones_activo
INSERT INTO "public".recepciones_activo (seq_recepcion_activo, cod_estado, fecha, seq_activo, seq_persona_recepcionante, seq_solicitud_servicio)
VALUES 
  (1,1, '2023-09-25', 1, 1, 1),
  (2,1, '2023-09-26', 2, 2, 2),
  (3,1, '2023-09-27', 3, 3, 3),
  (4,1, '2023-09-28', 4, 4, 4),
  (5,1, '2023-09-29', 5, 5, 5);

-- Insertar datos en la tabla "public".ordenes_trabajo_activo
INSERT INTO "public".ordenes_trabajo_activo (seq_activo, seq_orden_trabajo)
VALUES 
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5);

-- Insertar datos en la tabla "public".mantenimientos_correctivos
INSERT INTO "public".mantenimientos_correctivos (seq_mantenimiento_correctivo,cod_estado, cod_tipo_solucion, 
												 comentario_deteccion_falla, comentarios, descripcion_causa, 
												 descripcion_solucion, duracion, fecha_finalizacion, id_falla, seq_activo, seq_orden_trabajo)
VALUES 
  (1,1, 'Reparación', 'Pantalla rota', 'Reemplazo de pantalla', 'Pantalla dañada', 'Se reemplazó la pantalla', '2 horas', '2023-09-25', 1, 1, 1),
  (2,1, 'Reparación', 'Problema de alimentación', 'Reemplazo de fuente de poder', 'Fuente de poder defectuosa', 'Se reemplazó la fuente de poder', '3 horas', '2023-09-25', 2, 2, 2),
  (3,1, 'Reparación', 'Disco duro defectuoso', 'Reemplazo de disco duro', 'Disco duro fallido', 'Se reemplazó el disco duro', '4 horas', '2023-09-25', 3, 3, 3),
  (4,1, 'Reparación', 'Teclado dañado', 'Reemplazo de teclado', 'Teclado inoperable', 'Se reemplazó el teclado', '1.5 horas', '2023-09-25', 4, 4, 4),
  (5,1, 'Reparación', 'Problemas de red', 'Configuración de red', 'Problemas de conectividad', 'Se solucionaron los problemas de red', '2.5 horas', '2023-09-25', 5, 5, 5);

-- Insertar datos en la tabla "public".tecnicos_ejecutantes
INSERT INTO "public".tecnicos_ejecutantes (seq_tecnico_ejecutante, cod_estado, cod_responsable, fecha_de_asignacion, seq_orden_trabajo, seq_persona_ejecutante)
VALUES 
  (1,1, 0, '2023-09-25', 1, 1),
  (2,1, 0, '2023-09-26', 2, 2),
  (3,1, 0, '2023-09-27', 3, 3),
  (4,1, 0, '2023-09-28', 4, 4),
  (5, 1, 0, '2023-09-29', 5, 5);

-- Insertar datos en la tabla "public".tareas_mant_inspeccion_cronologica

INSERT INTO "public".tareas_mant_inspeccion_cronologica (seq_tarea_mant_inspeccion_cronologica, cod_ejecucion, cod_estado, descripcion, fecha, fotografia, hora, seq_mantenimiento_correctivo)
VALUES 
  (1,'EJ-001', 1, 'Tarea 1', '2023-09-25', 'foto1.jpg', '12:30:00', 1),
  (2,'EJ-002', 1, 'Tarea 2', '2023-09-26', 'foto2.jpg', '13:30:00', 2),
  (3,'EJ-003', 1, 'Tarea 3', '2023-09-27', 'foto3.jpg', '14:30:00', 3),
  (4,'EJ-004', 1, 'Tarea 4', '2023-09-28', 'foto4.jpg', '15:30:00', 4),
  (5,'EJ-005', 1, 'Tarea 5', '2023-09-29', 'foto5.jpg', '16:30:00', 5);
