DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- CREATE TABLE "public".activo (
--   seqactivo SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   comentarios varchar(500) NOT NULL,
--   idetiquetafisica varchar(100),
--   marca varchar(100) NOT NULL,
--   modelo varchar(100),
--   nombre varchar(100) NOT NULL
-- );

-- -- Definición de la tabla "public".fallas
-- CREATE TABLE "public".fallas (
--   idfalla SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   nombre varchar(250) NOT NULL
-- );

-- -- Definición de la tabla "public".mantenimientoscorrectivos
-- CREATE TABLE "public".mantenimientoscorrectivos (
--   seqmantenimientocorrectivo SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   codtiposolucion varchar(200) NOT NULL,
--   comentariodeteccionfalla varchar(1500) NOT NULL,
--   comentarios varchar(2500) NOT NULL,
--   descripcioncausa varchar(1500),
--   descripcionsolucion varchar(1500),
--   duracion varchar(200) NOT NULL,
--   fecha date NOT NULL,
--   idfalla int4 NOT NULL,
--   seqactivo int4 NOT NULL,
--   seqordentrabajo int4 NOT NULL
-- );

-- -- Definición de la tabla "public".ordenestrabajo
-- CREATE TABLE "public".ordenestrabajo (
--   seqordentrabajo SERIAL PRIMARY KEY,
--   codatendido int4 DEFAULT 0 NOT NULL,
--   codestado int4 DEFAULT 1 NOT NULL,
--   codtipomantenimiento varchar(4) NOT NULL,
--   fechaemision date NOT NULL,
--   numeroordentrabajo varchar(50) NOT NULL,
--   ubicacionactivo varchar(250),
--   seqpersonaplanificante int4 NOT NULL,
--   seqsolicitudservicio int4 NOT NULL
-- );

-- -- Definición de la tabla "public".ordenestrabajoactivo
-- CREATE TABLE "public".ordenestrabajoactivo (
--   seqactivo int4 NOT NULL,
--   seqordentrabajo int4 NOT NULL,
--   PRIMARY KEY (seqactivo, seqordentrabajo)
-- );

-- -- Definición de la tabla "public".personas
-- CREATE TABLE "public".personas (
--   seqpersona SERIAL PRIMARY KEY,
--   apellidomaterno varchar(40),
--   apellidopaterno varchar(40) NOT NULL,
--   cedulaidentidad varchar(15),
--   codestado int4 DEFAULT 1 NOT NULL,
--   codtipo varchar(1) NOT NULL,
--   fotografia varchar(255),
--   nombres varchar(40) NOT NULL,
--   telefonocelular varchar(20)
-- );

-- -- Definición de la tabla "public".menus
-- CREATE TABLE "public".menus (
--   codm SERIAL PRIMARY KEY,
--   estado int4 NOT NULL,
--   nombre varchar(40) NOT NULL
-- );

-- -- Definición de la tabla "public".procesos
-- CREATE TABLE "public".procesos (
--   codp SERIAL PRIMARY KEY,
--   enlace varchar(100) NOT NULL,
--   estado int4 NOT NULL,
--   nombre varchar(40) NOT NULL
-- );

-- -- Definición de la tabla "public".mepro
-- CREATE TABLE "public".mepro (
--   codm int4 NOT NULL,
--   codp int4 NOT NULL,
--   PRIMARY KEY (codm, codp)
-- );

-- -- Definición de la tabla "public".solicitudesservicio
-- CREATE TABLE "public".solicitudesservicio (
--   seqsolicitudservicio SERIAL PRIMARY KEY,
--   codestado int4 NOT NULL,
--   descripcionproblema varchar(1500),
--   fecha date NOT NULL,
--   seqpersonasolicita int4 NOT NULL
-- );

-- -- Definición de la tabla "public".recepcionesactivo
-- CREATE TABLE "public".recepcionesactivo (
--   seqrecepcionactivo SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   fecha date NOT NULL,
--   seqactivo int4 NOT NULL,
--   seqpersonarecepcionante int4 NOT NULL,
--   seqsolicitudservicio int4 NOT NULL
-- );

-- -- Definición de la tabla "public".roles
-- CREATE TABLE "public".roles (
--   idrol SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   nombre varchar(40) NOT NULL
-- );

-- -- Definición de la tabla "public".rolme
-- CREATE TABLE "public".rolme (
--   codm int4 NOT NULL,
--   codr int4 NOT NULL,
--   PRIMARY KEY (codm, codr)
-- );


-- -- Definición de la tabla "public".tareasmantinspeccioncronologica
-- CREATE TABLE "public".tareasmantinspeccioncronologica (
--   seqtareamantinspeccioncronologica SERIAL PRIMARY KEY,
--   codejecucion varchar(20) NOT NULL,
--   codestado int4 DEFAULT 1 NOT NULL,
--   descripcion varchar(500) NOT NULL,
--   fecha date NOT NULL,
--   fotografia varchar(255),
--   hora time(6) NOT NULL,
--   seqmantenimientocorrectivo int4 NOT NULL
-- );

-- -- Definición de la tabla "public".tecnicosejecutantes
-- CREATE TABLE "public".tecnicosejecutantes (
--   seqtecnicoejecutante SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   codresponsable int4 DEFAULT 0 NOT NULL,
--   fechadeasignacion date NOT NULL,
--   seqordentrabajo int4 NOT NULL,
--   seqpersonaejecutante int4 NOT NULL
-- );

-- CREATE TABLE "public".usuarios (
--   codu SERIAL PRIMARY KEY,
--   codestado int4 DEFAULT 1 NOT NULL,
--   login varchar(30),
--   password varchar(200) NOT NULL,
--   seqpersona int4 NOT NULL
-- );

-- -- Definición de la tabla "public".usuarioroles
-- CREATE TABLE "public".usuarioroles (
--   idrol int4 NOT NULL,
--   usuario int4 NOT NULL,
--   PRIMARY KEY (idrol, usuario)
-- );

-- -- Definición de las relaciones entre las tablas mediante claves foráneas
-- ALTER TABLE "public".rolme ADD CONSTRAINT fk8ws198lni8fbmsj7ibx7aj80 FOREIGN KEY (codm) REFERENCES "public".menus (codm) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".ordenestrabajoactivo ADD CONSTRAINT fkc19mcmc1v647y2b92qtlpljx7 FOREIGN KEY (seqactivo) REFERENCES "public".activo (seqactivo) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".mepro ADD CONSTRAINT fkevx4rvgf9j54cbvjw1g9wc6sx FOREIGN KEY (codp) REFERENCES "public".procesos (codp) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".mepro ADD CONSTRAINT fkmomj91ctnhbkk7182wnnvx31j FOREIGN KEY (codm) REFERENCES "public".menus (codm) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".usuarioroles ADD CONSTRAINT fkn1gequ2urvym49saljxh03n09 FOREIGN KEY (usuario) REFERENCES "public".usuarios (codu) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".usuarioroles ADD CONSTRAINT fko74ec96jhrl0qnl41u14osa2b FOREIGN KEY (idrol) REFERENCES "public".roles (idrol) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".rolme ADD CONSTRAINT fkqvxshkvqsrf2l0nu0dguick0n FOREIGN KEY (codr) REFERENCES "public".roles (idrol) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".ordenestrabajoactivo ADD CONSTRAINT fkt51y9hwovved4557s9m9nn2dx FOREIGN KEY (seqordentrabajo) REFERENCES "public".ordenestrabajo (seqordentrabajo) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".mantenimientoscorrectivos ADD CONSTRAINT mantenimientoscorrectivosidfallafkey FOREIGN KEY (idfalla) REFERENCES "public".fallas (idfalla) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".mantenimientoscorrectivos ADD CONSTRAINT mantenimientoscorrectivosseqactivofkey FOREIGN KEY (seqactivo) REFERENCES "public".activo (seqactivo) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".mantenimientoscorrectivos ADD CONSTRAINT mantenimientoscorrectivosseqordentrabajofkey FOREIGN KEY (seqordentrabajo) REFERENCES "public".ordenestrabajo (seqordentrabajo) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".ordenestrabajo ADD CONSTRAINT ordenestrabajoseqpersonaplanificantefkey FOREIGN KEY (seqpersonaplanificante) REFERENCES "public".personas (seqpersona) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- ALTER TABLE "public".ordenestrabajo ADD CONSTRAINT ordenestrabajoseqsolicitudserviciofkey FOREIGN KEY (seqsolicitudservicio) REFERENCES "public".solicitudesservicio (seqsolicitudservicio) ON UPDATE NO ACTION ON DELETE NO ACTION;
