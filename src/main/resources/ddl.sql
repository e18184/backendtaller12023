CREATE TABLE "public".activo (
  seq_activo SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  comentarios varchar(500) NOT NULL,
  id_etiqueta_fisica varchar(100),
  marca varchar(100) NOT NULL,
  modelo varchar(100),
  nombre varchar(100) NOT NULL
);

-- Definición de la tabla "public".fallas
CREATE TABLE "public".fallas (
  id_falla SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  nombre varchar(250) NOT NULL
);

-- Definición de la tabla "public".mantenimientos_correctivos
CREATE TABLE "public".mantenimientos_correctivos (
  seq_mantenimiento_correctivo SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  cod_tipo_solucion varchar(200) NOT NULL,
  comentario_deteccion_falla varchar(1500) NOT NULL,
  comentarios varchar(2500) NOT NULL,
  descripcion_causa varchar(1500),
  descripcion_solucion varchar(1500),
  duracion varchar(200) NOT NULL,
  fecha date NOT NULL,
  id_falla int4 NOT NULL,
  seq_activo int4 NOT NULL,
  seq_orden_trabajo int4 NOT NULL
);

-- Definición de la tabla "public".ordenes_trabajo
CREATE TABLE "public".ordenes_trabajo (
  seq_orden_trabajo SERIAL PRIMARY KEY,
  cod_atendido int4 DEFAULT 0 NOT NULL,
  cod_estado int4 DEFAULT 1 NOT NULL,
  cod_tipo_mantenimiento varchar(4) NOT NULL,
  fecha_emision date NOT NULL,
  numero_orden_trabajo varchar(50) NOT NULL,
  ubicacion_activo varchar(250),
  seq_persona_planificante int4 NOT NULL,
  seq_solicitud_servicio int4 NOT NULL
);

-- Definición de la tabla "public".ordenes_trabajo_activo
CREATE TABLE "public".ordenes_trabajo_activo (
  seq_activo int4 NOT NULL,
  seq_orden_trabajo int4 NOT NULL,
  PRIMARY KEY (seq_activo, seq_orden_trabajo)
);

-- Definición de la tabla "public".personas
CREATE TABLE "public".personas (
  seq_persona SERIAL PRIMARY KEY,
  apellido_materno varchar(40),
  apellido_paterno varchar(40) NOT NULL,
  cedula_identidad varchar(15),
  cod_estado int4 DEFAULT 1 NOT NULL,
  cod_tipo varchar(1) NOT NULL,
  fotografia varchar(255),
  nombres varchar(40) NOT NULL,
  telefono_celular varchar(20)
);

-- Definición de la tabla "public".menus
CREATE TABLE "public".menus (
  codm SERIAL PRIMARY KEY,
  estado int4 NOT NULL,
  nombre varchar(40) NOT NULL
);

-- Definición de la tabla "public".procesos
CREATE TABLE "public".procesos (
  codp SERIAL PRIMARY KEY,
  enlace varchar(100) NOT NULL,
  estado int4 NOT NULL,
  nombre varchar(40) NOT NULL
);

-- Definición de la tabla "public".mepro
CREATE TABLE "public".mepro (
  codm int4 NOT NULL,
  codp int4 NOT NULL,
  PRIMARY KEY (codm, codp)
);

-- Definición de la tabla "public".solicitudes_servicio
CREATE TABLE "public".solicitudes_servicio (
  seq_solicitud_servicio SERIAL PRIMARY KEY,
  cod_estado int4 NOT NULL,
  descripcion_problema varchar(1500),
  fecha date NOT NULL,
  seq_persona_solicita int4 NOT NULL
);

-- Definición de la tabla "public".recepciones_activo
CREATE TABLE "public".recepciones_activo (
  seq_recepcion_activo SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  fecha date NOT NULL,
  seq_activo int4 NOT NULL,
  seq_persona_recepcionante int4 NOT NULL,
  seq_solicitud_servicio int4 NOT NULL
);

-- Definición de la tabla "public".roles
CREATE TABLE "public".roles (
  id_rol SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  nombre varchar(40) NOT NULL
);

-- Definición de la tabla "public".rolme
CREATE TABLE "public".rolme (
  codm int4 NOT NULL,
  codr int4 NOT NULL,
  PRIMARY KEY (codm, codr)
);


-- Definición de la tabla "public".tareas_mant_inspeccion_cronologica
CREATE TABLE "public".tareas_mant_inspeccion_cronologica (
  seq_tarea_mant_inspeccion_cronologica SERIAL PRIMARY KEY,
  cod_ejecucion varchar(20) NOT NULL,
  cod_estado int4 DEFAULT 1 NOT NULL,
  descripcion varchar(500) NOT NULL,
  fecha date NOT NULL,
  fotografia varchar(255),
  hora time(6) NOT NULL,
  seq_mantenimiento_correctivo int4 NOT NULL
);

-- Definición de la tabla "public".tecnicos_ejecutantes
CREATE TABLE "public".tecnicos_ejecutantes (
  seq_tecnico_ejecutante SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  cod_responsable int4 DEFAULT 0 NOT NULL,
  fecha_de_asignacion date NOT NULL,
  seq_orden_trabajo int4 NOT NULL,
  seq_persona_ejecutante int4 NOT NULL
);

CREATE TABLE "public".usuarios (
  codu SERIAL PRIMARY KEY,
  cod_estado int4 DEFAULT 1 NOT NULL,
  login varchar(30),
  password varchar(200) NOT NULL,
  seq_persona int4 NOT NULL
);

-- Definición de la tabla "public".usuario_roles
CREATE TABLE "public".usuario_roles (
  id_rol int4 NOT NULL,
  usuario int4 NOT NULL,
  PRIMARY KEY (id_rol, usuario)
);

-- Definición de las relaciones entre las tablas mediante claves foráneas
ALTER TABLE "public".rolme ADD CONSTRAINT fk8ws198lni8fbmsj7ibx7aj80 FOREIGN KEY (codm) REFERENCES "public".menus (codm) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".ordenes_trabajo_activo ADD CONSTRAINT fkc19mcmc1v647y2b92qtlpljx7 FOREIGN KEY (seq_activo) REFERENCES "public".activo (seq_activo) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".mepro ADD CONSTRAINT fkevx4rvgf9j54cbvjw1g9wc6sx FOREIGN KEY (codp) REFERENCES "public".procesos (codp) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".mepro ADD CONSTRAINT fkmomj91ctnhbkk7182wnnvx31j FOREIGN KEY (codm) REFERENCES "public".menus (codm) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".usuario_roles ADD CONSTRAINT fkn1gequ2urvym49saljxh03n09 FOREIGN KEY (usuario) REFERENCES "public".usuarios (codu) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".usuario_roles ADD CONSTRAINT fko74ec96jhrl0qnl41u14osa2b FOREIGN KEY (id_rol) REFERENCES "public".roles (id_rol) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".rolme ADD CONSTRAINT fkqvxshkvqsrf2l0nu0dguick0n FOREIGN KEY (codr) REFERENCES "public".roles (id_rol) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".ordenes_trabajo_activo ADD CONSTRAINT fkt51y9hwovved4557s9m9nn2dx FOREIGN KEY (seq_orden_trabajo) REFERENCES "public".ordenes_trabajo (seq_orden_trabajo) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".mantenimientos_correctivos ADD CONSTRAINT mantenimientos_correctivos_id_falla_fkey FOREIGN KEY (id_falla) REFERENCES "public".fallas (id_falla) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".mantenimientos_correctivos ADD CONSTRAINT mantenimientos_correctivos_seq_activo_fkey FOREIGN KEY (seq_activo) REFERENCES "public".activo (seq_activo) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".mantenimientos_correctivos ADD CONSTRAINT mantenimientos_correctivos_seq_orden_trabajo_fkey FOREIGN KEY (seq_orden_trabajo) REFERENCES "public".ordenes_trabajo (seq_orden_trabajo) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".ordenes_trabajo ADD CONSTRAINT ordenes_trabajo_seq_persona_planificante_fkey FOREIGN KEY (seq_persona_planificante) REFERENCES "public".personas (seq_persona) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE "public".ordenes_trabajo ADD CONSTRAINT ordenes_trabajo_seq_solicitud_servicio_fkey FOREIGN KEY (seq_solicitud_servicio) REFERENCES "public".solicitudes_servicio (seq_solicitud_servicio) ON UPDATE NO ACTION ON DELETE NO ACTION;
