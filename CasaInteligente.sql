create table Tipos(
	id_tipo SERIAL not null primary key,
	nombre_tipo varchar (50) not null
)

create table Dispositivo(
	id_disp SERIAL not null primary key,
	nombre_disp varchar (50),
	es_activo BOOLEAN not null default false,
	id_tipo INTEGER REFERENCES tipos(id_tipo) not null
)

insert into Tipos (nombre_tipo) values ('Luz');
insert into Tipos (nombre_tipo) values ('Ventana');


insert into Dispositivo (nombre_disp, id_tipo) values ('Lucesita', 1);
insert into Dispositivo (nombre_disp, id_tipo) values ('Lucesita2', 1);
insert into Dispositivo (nombre_disp, id_tipo) values ('Lucesita3', 1);
insert into Dispositivo (nombre_disp, id_tipo) values ('Lucesita4', 1);
insert into Dispositivo (nombre_disp, id_tipo) values ('Ventanita', 2);
insert into Dispositivo (nombre_disp, id_tipo) values ('Ventanita2', 2);
insert into Dispositivo (nombre_disp, id_tipo) values ('Ventanita3', 2);


Update Dispositivo set es_activo = true where id_disp = 2;
Update Dispositivo set es_activo = false where id_disp = 2;

Select n.nombre_tipo, d.nombre_disp, d.es_activo, d.id_disp 
	from Tipos n join Dispositivo d
	on n.id_tipo = d.id_tipo;

Select d.nombre_disp, d.es_activo, d.id_disp from Tipos n join Dispositivo d on n.id_tipo = d.id_tipo;

Select * from Dispositivo;

Select * from Tipos;
