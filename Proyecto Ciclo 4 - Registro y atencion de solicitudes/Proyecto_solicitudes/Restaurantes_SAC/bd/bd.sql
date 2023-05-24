create database solicitudes_ventas;
go

use solicitudes_ventas;
go

create table tb_Documento(
tipoDocumento int not null,
descripcionDocumento varchar(100) not null,
primary key (tipoDocumento)
);
go

create table tb_usuario(
nombre varchar(100) not null,
apellidoPaterno varchar(100) not null,
apellidoMaterno varchar(100) not null,
tipoDocumento int not null,
numeroDocumento varchar(15) not null,
nombreUsuario varchar(50) unique,
contrasenia varchar(50) unique,
tipoUsuario varchar(50),
foreign key (tipoDocumento) references tb_Documento(tipoDocumento) 
);
go

create table departamento(
idDepartamento int identity (100,10),
desDepartamento varchar(100),
primary key (idDepartamento)
);
go

create table provincia(
idProvincia int identity(100,10),
desProvincia varchar(100),
primary key (idProvincia)
);
go

create table distrito(
idDistrito int identity(100,10),
desDistrito varchar(100),
primary key (idDistrito)
);
go

create table tb_clientes(
idCliente int identity(100,1),
nombres varchar(100) not null,
apellidoPaterno varchar(100) not null,
apellidoMaterno varchar(100) not null,
tipoDocumento int not null,
numeroDocumento varchar(15) not null,
idDepartamento int not null,
idProvincia int not null,
idDistrito int not null,
direccion varchar(100) not null,
email varchar(100) not null,
celular varchar(15) not null,
primary key(idCliente),
foreign key(tipoDocumento) references tb_Documento(tipoDocumento),
foreign key (idDepartamento) references departamento(idDepartamento),
foreign key (idProvincia) references provincia(idProvincia),
foreign key (idDistrito) references distrito(idDistrito)
);
go

create table tb_comprobante_pago(
tipoComprobante varchar(50) not null,
numeroComprobante varchar(50) not null,
fechaComprobante varchar(50) not null,
nombresCliente varchar(100) not null,
apellidosClientes varchar(100) not null,
tipDocumento int not null,
numeroDocumento varchar(15) not null,
importe decimal(8,2),
estado varchar(50) default 'cancelado',
primary key(numeroComprobante),
foreign key(tipDocumento) references tb_Documento(tipoDocumento)
);
go

create table tb_solicitud(
idSolicitud int identity(1,1),
tipoDocumento int not null,
numeroDocumento varchar(15) not null,
nombres varchar(100) not null,
apellidoPaterno varchar(100) not null,
apellidoMaterno varchar(100) not null,
telefono varchar(15) null,
celular varchar(15) null,
correo varchar(50) not null,
departamento int not null,
provincia int not null,
distrito int not null,
direccion varchar(100) not null,
tipoSolicitud varchar(50)  not null,
tipoMotivo varchar(50) not null,
fechaSolicitud varchar(50) not null,
fechaComprobante varchar(20) not null,
numeroComprobante varchar(20) not null,
tienda varchar(50) not null,
servicio varchar(250) not null,
descripcionSolicitud varchar(250) not null,
respuestaSolicitud varchar(250) null,
estado varchar(50) not null,
primary key (idSolicitud),
foreign key (tipoDocumento) references tb_Documento(tipoDocumento),
foreign key (departamento ) references departamento(idDepartamento),
foreign key (provincia) references provincia ( idProvincia),
foreign key (distrito) references distrito (idDistrito)
);
go

insert into tb_documento values (1 , 'DNI');
insert into tb_documento values (2 , 'RUC');
insert into tb_documento values (3 , 'Pasaporte');

insert into departamento values ('Lima');
insert into departamento values ('Callao');
insert into departamento values ('Piura');
insert into departamento values ('Tumbes');
insert into departamento values ('Arequipa');
insert into departamento values ('Cusco');
insert into departamento values ('Cajamarca');

insert into distrito values ('Lima');
insert into distrito values ('Miraflores');
insert into distrito values ('Los Olivos');
insert into distrito values ('Santa Anita');
insert into distrito values ('La Molina');
insert into distrito values ('San Juan de Lurigancho');
insert into distrito values ('San Martin de Porres');

insert into provincia values ('Lima');
insert into provincia values ('Huancayo');	
insert into provincia values ('Arequipa');
insert into provincia values ('Huaral');
insert into provincia values ('Cusco');
insert into provincia values ('Arequipa');

