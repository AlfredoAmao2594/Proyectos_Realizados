DROP DATABASE IF EXISTS electrodomesticos;
-- creamos la bd
CREATE DATABASE electrodomesticos;
-- activamos la bd
USE electrodomesticos;

create table proveedor
(
id_proveedor bigint primary key ,
razon_social varchar (200) ,
direccion varchar (150),
telefono varchar(9),
correo varchar (30)
);

insert into proveedor values (20121523695,'Importaciones Electricas SAC','Av Javier Prado Oeste 154','925632145','importaciones@gmail.com');
insert into proveedor values (20112558974,'EletroHogar EIRL','Av Alfonso Ugarte 154','978456123','eletroHogar@gmail.com');
insert into proveedor values (20174885478,'Carsa SAC','Av Nicolas de Pierola 1412','978456123','carsa@gmail.com');


create table usuario
(
id_vendedor varchar (10) primary key,
nombre_vendedor varchar(100),
apellido_vendedor varchar(100),
dni_vendedor varchar(10) unique
);

insert into usuario values('72569823','Luis','Torres','72569823');
insert into usuario values('72623612','Andres','Vivanco','72623612');
insert into usuario values('08256548','Laura','Ramirez','08256548');


create table tipo_documento_identidad
(
codigo_doc int primary key,
detalle varchar(50)
);

insert into tipo_documento_identidad values (1,'DNI');
insert into tipo_documento_identidad values (2,'RUC');
insert into tipo_documento_identidad values (3,'Pasaporte');

create table tipo_comprobante_pago
(
codigo_comp int primary key,
detalle_comp varchar(100)
);

insert into tipo_comprobante_pago values (1,'factura');
insert into tipo_comprobante_pago values (2,'boleta');
insert into tipo_comprobante_pago values (3,'nota de credito');
insert into tipo_comprobante_pago values (4,'nota de debito');


create table producto
(
id_producto int primary key,
deta_producto varchar (200),
marca varchar (100),
precio double,
id_proveedor bigint,
foreign key (id_proveedor) references proveedor (id_proveedor)
);

insert into producto values (102,'Television 55 UHD', 'Samsumg',2500,20121523695);
insert into producto values (103,'Microondas Horno de 1200 watts', 'LG',550,20112558974);
insert into producto values (104,'Equipo de sonido 1200', 'Sony',1450,20174885478);

create table cliente 
(
id_cliente bigint primary key,
codigo_doc int,
nombre_cliente varchar (200),
direccion_c?liente varchar(200),
foreign key(codigo_doc) references tipo_documento_identidad(codigo_doc)
);

ALTER TABLE CLIENTE ADD telefono varchar(9);
Alter table cliente add correo varchar(30);

insert into cliente values('72485232','1','Enrique Quispe','Calle la Cuba 145','925748589','enrique@gmail.com');
insert into cliente values('07859632','1','Thomas Sosa','Jiron ICA 145','978456131','thomas@gmail.com');
insert into cliente values('20156523478','2','Electro casas EIRL','av Arequipa 4521','951357258','electro@gmail.com');

create table estado(
codEstado  int auto_increment,
desEstado  varchar(200) ,
primary key (codEstado)
);

insert into estado values (null,'pendiente');
insert into estado values (null,'anulado');
insert into estado values (null,'aceptado');
create table ticket
(
numero_ticket char(5)not null ,
fecha date ,
id_producto int ,
deta_producto varchar(200),
precio double not null,
id_vendedor varchar(20),
cantidad int not null,
codEstado int,
primary key (numero_ticket),
foreign key (id_producto) references producto (id_producto),
foreign key (id_vendedor) references usuario(id_vendedor),
foreign key (codEstado) references estado(codEstado)
);

create table comprobante_pago_cab
(
numero_factura char(5) not null,
fecha date not null,
codigo_comp int not null,
id_cliente bigint not null,
base_comprobante decimal (8,2),
igv_comprobante decimal (8,2),
total_comprobante decimal (8,2),
primary key (numero_factura),
foreign key(codigo_comp) references tipo_comprobante_pago(codigo_comp) ,
foreign key(id_cliente) references cliente (id_cliente)
);

create table comprobante_pago_deta
(
numero_factura char(5) not null,
numero_ticket char(5) not null ,
id_producto int not null,
deta_producto varchar(200) not null,
cantidad int not null,
precio decimal (8,2),
importe decimal(8,2),
foreign key(numero_factura) references comprobante_pago_cab(numero_factura),
foreign key(numero_ticket) references ticket(numero_ticket),
foreign key(id_producto) references producto(id_productO)
);

