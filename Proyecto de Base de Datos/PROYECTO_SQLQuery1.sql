CREATE DATABASE PROYECTO_TX2L
GO

CREATE TABLE MEDIO_PAGO(
COD_PAG CHAR(3) UNIQUE,
DEST_PAG VARCHAR(20)
)

CREATE TABLE PROVEEDOR(
RUC VARCHAR(11) PRIMARY KEY,
RAZ_SOC VARCHAR(50),
DIR_PROV VARCHAR (100),
TEL_PROV INT,
TIP_PROV VARCHAR (20)
)

CREATE TABLE DETALLE_PRODUCTO(
COD_PRO INT PRIMARY KEY IDENTITY(100,1),
DES_PRO VARCHAR(50),
MARCA VARCHAR(20),
TIPO VARCHAR(20)
)

CREATE TABLE PRODUCTO(
COD_PRO INT FOREIGN KEY REFERENCES DETALLE_PRODUCTO(COD_PRO),
COS_PRO MONEY,
PRE_PRO MONEY,
STOCK CHAR(10)
)

CREATE TABLE ORDEN_COMPRA(
NUM_ORD INT PRIMARY KEY,
COD_PRO INT FOREIGN KEY REFERENCES [dbo].[DETALLE_PRODUCTO](COD_PRO),
RUC VARCHAR(11) FOREIGN KEY REFERENCES [dbo].[PROVEEDOR](RUC),
CANTIDAD INT,
FECHA DATE,
APROB VARCHAR (50),
COD_PAG CHAR(3)
)

CREATE TABLE CENTRO_DISTRIBUCION(
COD_CENT INT PRIMARY KEY IDENTITY (100,1),
DIRECCION VARCHAR (50)
)

CREATE TABLE ALMACEN(
COD_ALMA INT PRIMARY KEY IDENTITY (1001,1),
CAPACIDAD INT ,
TIPO VARCHAR (50)
)

CREATE TABLE TIENDA(
COD_TIE CHAR(5) PRIMARY KEY,
NOM_TIE VARCHAR (50),
DIRECCION VARCHAR (100),
)

CREATE TABLE ORDEN_DESPACHO(
NUM_DES INT PRIMARY KEY,
COD_PRO INT FOREIGN KEY REFERENCES [dbo].[DETALLE_PRODUCTO] (COD_PRO),
COD_TIEN CHAR (5) FOREIGN KEY REFERENCES[dbo].[TIENDA] (COD_TIE),
COD_CENT INT FOREIGN KEY REFERENCES [dbo].[CENTRO_DISTRIBUCION](COD_CENT),
COD_ALMA INT FOREIGN KEY REFERENCES [dbo].[ALMACEN](COD_ALMA),
FECHA DATE ,
CANTIDAD INT,
)

CREATE TABLE FLOTA_VEHICULAR(
COD_FLO CHAR(5) PRIMARY KEY,
PLACA CHAR(6) UNIQUE,
CAPACIDAD INT,
MARCA VARCHAR(20),
TIPO VARCHAR (20)
)

CREATE TABLE EMPLEADO(
DNI CHAR (10) PRIMARY KEY,
NOMBRE VARCHAR(50),
APELLIDO VARCHAR (50),
TEL_EMP CHAR (9),
TIPO VARCHAR (20),
SEXO CHAR(1) CHECK( SEXO IN ('M','F')),
EDAD CHAR (5),
DIRECCION VARCHAR (50)
)

CREATE TABLE GUIA_REMISION(
NUM_GUI INT PRIMARY KEY ,
NUM_ORD INT FOREIGN KEY REFERENCES[dbo].[ORDEN_DESPACHO](NUM_DES),
FECHA DATE,
DIR_INI VARCHAR(50),
DIR_FIN VARCHAR(50),
DNI CHAR(10) FOREIGN KEY REFERENCES [dbo].[EMPLEADO](DNI),
COD_FLO CHAR(5) FOREIGN KEY REFERENCES[dbo].[FLOTA_VEHICULAR](COD_FLO)
)

CREATE TABLE CLIENTE(
NUM_ID CHAR(15) PRIMARY KEY,
NOMBRE VARCHAR (50),
APELLIDO VARCHAR (50),
TELEFONO CHAR(10),
DIRECCION VARCHAR  (50)
)

CREATE TABLE COMPRBANTE_VENTA(
NUM_COM INT PRIMARY KEY,
FECHA DATE ,
COD_PRO INT FOREIGN KEY REFERENCES[dbo].[DETALLE_PRODUCTO](COD_PRO),
CANTIDAD INT,
TIPO CHAR(10),
PRECIO MONEY,
DNI CHAR(10)FOREIGN KEY REFERENCES [dbo].[EMPLEADO](DNI), 
NUM_ID CHAR (15) FOREIGN KEY REFERENCES [dbo].[CLIENTE] (NUM_ID),
COD_TIE CHAR (5) FOREIGN KEY REFERENCES [dbo].[TIENDA] (COD_TIE)
)

CREATE TABLE RECLAMO_DEVOLUCION(
NUM_ORD INT FOREIGN KEY REFERENCES [dbo].[ORDEN_COMPRA] (NUM_ORD),
NUM_REC CHAR(5) PRIMARY KEY,
DES_REC VARCHAR(100),
)

CREATE TABLE DEVOLUCION_MERCADERIA(
NUM_DEV CHAR(5),
NUM_GUI INT FOREIGN KEY REFERENCES [dbo].[GUIA_REMISION](NUM_GUI),
DES_DEV VARCHAR(100)
)


INSERT INTO [dbo].[MEDIO_PAGO] VALUES 
('001','TRANSFERENCIA'),
('002','CHEQUE'),
('003','DEPOSITO'),
('004','EFECTIVO'),
('005','LETRA'),
('006','CREDITO')

INSERT INTO [dbo].[PROVEEDOR] VALUES
('20102552369','NESTLE SAA','CARRETERA CENTRAL 154 LA VICTORIA',3267450,'ALIMENTOS'),
('20115485236','ELECTRODOMESTICOS INC SAC','AV PANAMERICANA NORTE 5263 LOS OLIVOS',4528635,'ELECTRODOMESTICOS'),
('20154563258','BRAEDT','AV SEPARADORA INDUSTRIAL 1415 ATE VITARTE',74585635,'ALIMENTOS'),
('10145263258','TALLERES DON JUAN SAC','CARRETERA CENTRAL 7584',4256328,'MUEBLERIA'),
('20415836758','IMPORTADORA TECNOLOGY SAC','AV JAVIER PRADO OESTE 2523',7458563,'TECNOLOGIA'),
('10142587455','SAN FERNADO SAC','AV ALFREDO BENAVIDES 3265',4256329,'ALIMENTOS'),
('20362589745','ALICORP CORC SAA','AV CARRETERA CENTRAL 4256 LA VICTORIA',42585472,'ALIMENTOS'),
('10142536856','PESQUERA NUEVA MAR EIRL','AV MARISCAL 1512 CALLAO',4257456,'ALIMENTOS'),
('10452365896','CASA DE MADERA EIRL','AV EL EJERCITO SUR LURIN',4253697,'MUEBLERIA'),
('20154785265','SONY TECNOLOGY SAA','AV JOSE PARDO 3526',3265261,'TECNOLOGIA')

INSERT INTO [dbo].[DETALLE_PRODUCTO] VALUES
('MESA','ROBLEX','MUEBLE'),
('SILLA','ROBLES','MUEBLE'),
('TELEVISOR 55','SAMSUMG','ELECTRODOMESTICO'),
('LECHE','GLORIA','ALIMENTO'),
('YOGURT','GLORIA','ALIMENTO'),
('JAMON PIZZA','BRAEDT','ALIMENTO'),
('PESCADO PEJERREY','PESCADOS ARTHUR','ALIMENTO'),
('MICROONDAS','SAMSUMG','ELECTRODIMESTICO'),
('LAVAVAJILLAS','SAPOLIO','ASEO'),
('JABON','NEKO','ASEO')


INSERT INTO [dbo].[PRODUCTO] VALUES
(100,'300','350','100'),
(101,'50','70','100'),
(102,'2000','2500','50'),
(103,'3','4','150'),
(104,'4.50','5.50','125'),
(105,'15','20','50'),
(106,'20','25','25'),
(107,'300','350','50'),
(108,'5','7','85'),
(109,'3','4','50')

INSERT INTO [dbo].[ORDEN_COMPRA]VALUES
(202210001,100,'10145263258',50,'2022-07-12','LUIS CARRERA','001'),
(202210002,101,'10145263258',50,'2022-07-07','LUIS CARRERA','001'),
(202210003,102,'20415836758',45,'2022-07-01','ALBERTO SAENZ','003'),
(202210004,103,'20102552369',200,'2022-07-30','EDUARDO CARNERO','002'),
(202210005,104,'20102552369',200,'2022-05-15','EDUARDO CARNERO','002'),
(202210006,105,'20154563258',20,'2022-06-10','YAZMIN MELO','003'),
(202210007,106,'10142536856',20,'2022-05-01','GUILLERMO IZAGUIRRE','001'),
(202210008,107,'20415836758',40,'2022-03-15','ALBERTO SAENZ','003'),
(202210009,108,'20362589745',85,'2022-01-01','LUIS CARRERA','001'),
(202210010,109,'20362589745',90,'2022-02-28','LUIS CARRERA','001'),
(202210011,100,'10145263258',50,'2022-05-16','LUIS CARRERA','003'),
(202210012,106,'10142536856',40,'2022-04-10','GUILLERMO IZAGUIRRE','001'),
(202210013,109,'20362589745',30,'2022-03-11','LUIS CARRERA','002')

INSERT INTO [dbo].[CENTRO_DISTRIBUCION] VALUES
('AV SEPARADORA INDUSTRIAL 1415 LA MOLINA'),
('AV JAVIE PRADO OESTE 3556 SAN SAN ISIDRO'),
('AV FENRANDO IVARRE 1452 ATE VITARTE')

INSERT INTO [dbo].[ALMACEN] VALUES
('1500','EMBUTIDOS'),
('1000','MUEBLES'),
('1200','ELECTROMESTICOS'),
('1500','ASEO'),
('1200','FRUTAS'),
('1000','BEBIDAS')

INSERT INTO [dbo].[TIENDA] VALUES
('TL001','PLAZA VEA LOS OLIVOS','PANAMERICANA NORTE 7556 LOS OLIVOS'),
('TL002','WONG CAMACHO','AV LA MOLINA  4523 ATE VITARTE'),
('TL003','PLAZA VEA OVALO','AV CARRETERA CENTRAL 3565 SANTA ANITA'),
('TL004','WONG CAMACHO','AV LA MOLINA  4523 ATE VITARTE'),
('TL005','PLAZA VEA JOCKEY','AV JAVIE PRADO ESTE 1542 SURCO'),
('TL006','PLAZA VEA LA RAMBLA','AV AVIACION 5263 SAN BORJA'),
('TL007','METRO BRE�A','AV ALFONSO UGARTE 3152 BRE�A'),
('TL008','PLAZA VEA ALCAZAR','AV ALCAZAR 2552 RIMAC')

INSERT INTO [dbo].[ORDEN_DESPACHO] VALUES
(20221010,100,'TL001',100,'1002','2022-06-25',20),
(20221011,101,'TL002',101,'1002','2022-05-31',25),
(20221012,104,'TL005',100,'1006','2022-03-21',30),
(20221013,107,'TL008',102,'1003','2022-01-15',15),
(20221014,109,'TL007',101,'1004','2022-01-02',18),
(20221015,105,'TL004',100,'1006','2022-02-15',25),
(20221016,101,'TL001',102,'1002','2022-02-28',30),
(20221017,103,'TL005',100,'1006','2022-02-10',35),
(20221018,108,'TL007',101,'1004','2022-05-15',40),
(20221019,100,'TL003',102,'1002','2022-05-15',25)

INSERT INTO [dbo].[FLOTA_VEHICULAR] VALUES
('FL001','AUX725','600','VOLVO','CARGA PESADA'),
('FL002','FLV451','400','VOLVO','CARGA MEDIA'),
('FL003','FUV452','350','VOLVO','CARGA LIVIANA'),
('FL004','XFR756','400','VOLVO','CARGA MEDIA'),
('FL005','FCV452','420','VOLVO','CARGA MEDIA'),
('FL006','AUZ756','600','VOLVO','CARGA PESADA'),
('FL007','AUR745','500','VOLVO','CARGA PESADA'),
('FL008','ASH452','400','VOLVO','CARGA MEDIA'),
('FL009','VRJ745','350','VOLVO','CARGA LIVIANA'),
('FL010','AUC456','300','VOLVO','CARGA LIVIANA')

INSERT INTO	[dbo].[EMPLEADO] VALUES
('72641525','ALEJANDRO','LOPEZ','923581745','CONDUCTOR','M','32','CALLE LAS FLORES 154 RIMAC'),
('45285636','RODOLFO','VILCHEZ','925874856','CONDUCTOR','M','45','CALLE LAS ORQUIDIAS 254 SANTA ANITA'),
('42585692','GAEL','TOLEDO','925478563','AMINISTRADOR','M','33','CALLE RIVERO 142 SAN LUIS'),
('74585695','MARCELO','CANALES','947852632','REPONEDOR','M','28','JIRON ICA 144 LIMA'),
('45213258','MAX','LUJAN','974586325','ALMACENERO','M','23','JIRO UCAYALI 146 LIMA'),
('10052478','ANGELO','TORRES','945785632','CONDUCTOR','M','22','AV AREQUIPA 3425 LINCE'),
('10012533','PALOMA','JULCA','956785412','CONDUCTOR','F','30','AV SEPARADORA INDUSTRIA 2655 ATE VITARTE'),
('10245783','IAN','QUISPE','958745623','CAJERO','M','31','CALLE JAZMIN 145 SANATA ANITA'),
('10548569','ALFREDO','SUAREZ','914725639','ALMACENERO','M','38','AV ALFREDO BENAVIDES 3526 MIRAFOLORES'),
('52014833','MARINA','BOLIVAR','978526320','CAJERO','F','40','CALLE LAS FLORES 154 RIMAC')

INSERT INTO [dbo].[GUIA_REMISION] VALUES 
(202201001,20221010,'2022-06-01','AV SEPARADORA INDUSTRIAL 1415 LA MOLINA','PANAMERICANA NORTE 7556 LOS OLIVOS','10012533','FL001'),
(202201002,20221011,'2022-01-15','AV JAVIE PRADO OESTE 3556 SAN SAN ISIDRO','AV LA MOLINA  4523 ATE VITARTE','10052478','FL002'),
(202201003,20221012,'2022-01-20','AV SEPARADORA INDUSTRIAL 1415 LA MOLINA','AV CARRETERA CENTRAL 3565 SANTA ANITA','45285636','FL004'),
(202201004,20221013,'2022-03-30','AV FENRANDO IVARRE 1452 ATE VITARTE','AV LA MOLINA  4523 ATE VITARTE','72641525','FL001'),
(202201005,20221014,'2022-04-10','AV SEPARADORA INDUSTRIAL 1415 LA MOLINA','PANAMERICANA NORTE 7556 LOS OLIVOS','10012533','FL005'),
(202201006,20221015,'2022-07-15','AV JAVIE PRADO OESTE 3556 SAN SAN ISIDRO','AV JAVIE PRADO ESTE 1542 SURCO','10012533','FL009'),
(202201007,20221016,'2022-08-20','AV SEPARADORA INDUSTRIAL 1415 LA MOLINA','AV ALFONSO UGARTE 3152 BRE�A','72641525','FL007'),
(202201008,20221017,'2022-07-01','AV FENRANDO IVARRE 1452 ATE VITARTE','AV ALCAZAR 2552 RIMAC','10052478','FL002'),
(202201009,20221018,'2022-06-13','AV SEPARADORA INDUSTRIAL 1415 LA MOLINA','AV JAVIE PRADO ESTE 1542 SURCO','45285636','FL006'),
(202201010,20221019,'2022-06-02','AV JAVIE PRADO OESTE 3556 SAN SAN ISIDRO','AV LA MOLINA  4523 ATE VITARTE','72641525','FL008')

INSERT INTO [dbo].[CLIENTE] VALUES
('72568935','RAUL','ROMERO','925632856','CALLE SAN PABLO 1452 BRE�A'),
('25836974','ENRIQUE','PEREZ','924753869','CALLE DE LORENZO 142 EL AGUSTINO'),
('10452563','LAURA','SOSA','945852356','AV VIA FERROCARRIL 253 ATE VITARTE'),
('72548639','YAZMIN','LINO','942532528','CALLE 14 RIMAC'),
('45236152','ENRIQUE','LUCAR','914562368','CALLE FLOR DE LOTO 1415 SANTA ANITA'),
('45237851','SULIMAN','LOPEZ','945658259','AV LOS ARBOLES DE NOCHETO EL AGUSTINO'),
('72548569','LEONARDO','ORIBION','978953654','CALLE AMANCAES 143 RIMAC'),
('12345756','NARCISO','VILLAREAL','947852369','JIRON QUILCA 1456 LIMA'),
('45278965','JEFFERSON','VALCARCEL','974852147','AV TACNA 1452 LIMA'),
('42154873','MARINA','TOLEDO','965325745','CALLE LAS ORQUIDEAS DEL AGUSTINO 745')


INSERT INTO [dbo].[COMPRBANTE_VENTA] VALUES
(00100001,'2022-06-13',101,2,'MUEBLE','350','10245783','10452563','TL004'),
(00100002,'2022-06-15',104,3,'LACTEO','16.50','52014833','25836974','TL006'),
(00100003,'2022-06-20',102,1,'TELEVISION','2500','10245783','72568935','TL003'),
(00100004,'2022-05-10',107,4,'ELECTRODOM','350','10245783','42154873','TL004'),
(00100005,'2022-04-11',106,5,'PESCADO','25','52014833','45278965','TL001'),
(00100006,'2022-04-12',104,6,'LACTEO','5.50','10245783','45237851','TL008'),
(00100007,'2022-05-30',103,3,'LACTEO','4','10245783','45236152','TL003'),
(00100008,'2022-06-14',102,1,'TELEVISION','2500','10245783','10452563','TL006'),
(00100009,'2022-05-12',101,2,'MUEBLE','70','52014833','72548639','TL004'),
(00100010,'2022-07-14',108,1,'ASEO','7','10245783','25836974','TL002')

INSERT INTO [dbo].[RECLAMO_DEVOLUCION] VALUES
(202210011,'RE001','MERCADERIA INCOMPLETA'),
(202210012,'RE002','MERCADERIA DA�ADA'),
(202210013,'RE003','MERCADERIA INCONRRECTA')

INSERT INTO [dbo].[DEVOLUCION_MERCADERIA] VALUES
('DM001',202201004,'MERCADERIA INCORRECTA'),
('DM002',202201007,'MERCADERIA EN MAL ESTADO'),
('DM003',202201008,'SOBREENVIO DE MERCADERIA')
GO


----VISTA CREADA--

CREATE VIEW ORDEN_COMPRA_COMPLETO
AS
SELECT ord.NUM_ORD,ord.COD_PRO,det.DES_PRO,ord.RUC,prov.RAZ_SOC,ord.CANTIDAD,ord.FECHA,ord.APROB,ord.COD_PAG,med.DEST_PAG
FROM[dbo].[ORDEN_COMPRA] ord, [dbo].[PRODUCTO] pro,[dbo].[DETALLE_PRODUCTO] det,[dbo].[MEDIO_PAGO] med,[dbo].[PROVEEDOR] prov
WHERE ord.COD_PRO= det.COD_PRO AND
ord.RUC=prov.RUC AND
ord.COD_PAG=med.COD_PAG AND
ord.COD_PRO=pro.COD_PRO
GO

SELECT * FROM ORDEN_COMPRA_COMPLETO
GO

CREATE VIEW ORDEN_DE_DESPACHO_COMPLETO
AS
SELECT ord.NUM_DES,ord.COD_PRO,det.DES_PRO,det.MARCA,ord.COD_TIEN,tie.NOM_TIE,ord.COD_CENT,cent.DIRECCION,ord.COD_ALMA,alma.TIPO,ord.FECHA,ord.CANTIDAD
FROM[dbo].[ORDEN_DESPACHO]ord,[dbo].[DETALLE_PRODUCTO]det,[dbo].[TIENDA]tie,[dbo].[CENTRO_DISTRIBUCION]cent,[dbo].[ALMACEN]alma
WHERE ord.COD_PRO=det.COD_PRO AND
ord.COD_TIEN=tie.COD_TIE AND
ord.COD_CENT=cent.COD_CENT AND
ord.COD_ALMA=alma.COD_ALMA
GO

SELECT * FROM ORDEN_DE_DESPACHO_COMPLETO
GO

CREATE VIEW GUIA_REMISION_COMPLETO
AS
SELECT gui.NUM_GUI,ord.NUM_DES,ord.COD_PRO,det.DES_PRO,ord.COD_TIEN,tie.NOM_TIE,ord.CANTIDAD,gui.FECHA,gui.DIR_INI,gui.DIR_FIN,gui.DNI,emp.NOMBRE,emp.APELLIDO,emp.TIPO,gui.COD_FLO,flo.MARCA,flo.PLACA
FROM[dbo].[GUIA_REMISION]gui,[dbo].[ORDEN_DESPACHO]ord,[dbo].[TIENDA]tie,[dbo].[DETALLE_PRODUCTO]det,[dbo].[EMPLEADO]emp,[dbo].[FLOTA_VEHICULAR] flo
WHERE gui.NUM_ORD=ord.NUM_DES AND
ord.COD_PRO=det.COD_PRO AND
ord.COD_TIEN=tie.COD_TIE AND
gui.DNI=emp.DNI AND
gui.COD_FLO=flo.COD_FLO
GO

SELECT * FROM GUIA_REMISION_COMPLETO
GO

CREATE VIEW COMPROBANTE_VENTA_COMPLETO
AS
SELECT com.NUM_COM,com.FECHA,com.COD_PRO,det.DES_PRO,det.MARCA,com.CANTIDAD,com.TIPO,com.PRECIO,com.DNI,emp.NOMBRE,emp.APELLIDO,com.NUM_ID,cli.NOMBRE NOMBRE_CLI,cli.APELLIDO APELLIDO_CLI,com.COD_TIE,tie.NOM_TIE
FROM [dbo].[COMPRBANTE_VENTA]com,[dbo].[DETALLE_PRODUCTO]det,[dbo].[EMPLEADO]emp,[dbo].[CLIENTE]cli,[dbo].[TIENDA]tie
WHERE com.COD_PRO=det.COD_PRO AND
com.DNI=emp.DNI AND
com.NUM_ID=cli.NUM_ID AND
com.COD_TIE=tie.COD_TIE
GO

SELECT * FROM COMPROBANTE_VENTA_COMPLETO 
GO

CREATE VIEW STOCK_MERCADERIA
AS
SELECT ord.COD_PRO,det.DES_PRO,det.MARCA,det.TIPO,pro.COS_PRO,pro.STOCK,ord.CANTIDAD
FROM[dbo].[ORDEN_COMPRA]ord,[dbo].[DETALLE_PRODUCTO]det,[dbo].[PRODUCTO]pro
WHERE ord.COD_PRO=det.COD_PRO AND
pro.COD_PRO=det.COD_PRO
GO

SELECT * FROM STOCK_MERCADERIA
GO


-----PROCEDIMIENTOS ALMACENADOS --------

CREATE PROCEDURE TB_INSERT_CLIENTES(
@p_NUM_ID CHAR(15),
@p_NOMBRE VARCHAR(50),
@p_APELLIDO VARCHAR (50),
@p_TELEFONO CHAR(10),
@p_DIRECCION VARCHAR(50)
)
AS
BEGIN
IF NOT EXISTS(SELECT * FROM [dbo].[CLIENTE] WHERE NUM_ID=@p_NUM_ID)
	INSERT INTO [dbo].[CLIENTE] VALUES (@p_NUM_ID,@p_NOMBRE,@p_APELLIDO,@p_TELEFONO,@p_DIRECCION)
	ELSE
	PRINT 'DOCUMENTO DE IDENTIDAD DEL CLIENTE YA EXISTE'

END
GO

EXEC TB_INSERT_CLIENTES '72545625','ALFREDO','AMAO','925638745','CALLE EL SALVADO 154'

SELECT * FROM [dbo].[CLIENTE] WHERE NUM_ID = '72545625'
GO

CREATE PROCEDURE TB_INSERT_PROVEEDOR(
@p_RUC VARCHAR(11),
@p_RAZ_SOC VARCHAR(11),
@p_DIR_PRO VARCHAR (100),
@p_TEL_PROV INT,
@p_TIP_PROV VARCHAR (20)
)
AS
BEGIN
IF NOT EXISTS(SELECT * FROM [dbo].[PROVEEDOR] WHERE RUC=@p_RUC)
	INSERT INTO [dbo].[PROVEEDOR] VALUES  (@p_RUC,@p_RAZ_SOC,@p_DIR_PRO,@p_TEL_PROV,@p_TIP_PROV)
	ELSE
	PRINT 'EL NUMERO DE RUC DEL PROVEEDOR YA EXISTE'

END
GO

EXEC TB_INSERT_PROVEEDOR '20154625147','FIRENO SAC','CALLE CHIMU 145 SAN JUAN DE LURIGANCHO','925368745','MADERERA'

SELECT * FROM [dbo].[PROVEEDOR] WHERE RUC='20154625147'
GO

CREATE PROCEDURE TB_SELECT_RECLAMO
(@p_NUM_ORD INT)
AS
BEGIN
	IF EXISTS (SELECT * FROM [dbo].[RECLAMO_DEVOLUCION] WHERE NUM_ORD=@p_NUM_ORD)	
		PRINT'LA ORDEN DE COMPRA ESTA EN PROCESO DE RECLAMO'
	ELSE
		PRINT'LA ORDEN DE COMPRA NO ESTA EN PROCESO DE RECLAMO'
END
GO


EXEC TB_SELECT_RECLAMO '202210001'

EXEC TB_SELECT_RECLAMO '202210011'
GO

CREATE PROCEDURE TB_SELECT_DEVOLUCION
(@p_NUM_GUI INT )
AS
BEGIN
	IF EXISTS (SELECT * FROM [dbo].[DEVOLUCION_MERCADERIA] WHERE NUM_GUI=@p_NUM_GUI)	
		PRINT'LA MERCADERIA SERA REGRESADA A ALMACEN'
	ELSE
		PRINT'LA MERCADERIA NO ESTA EN PROCESO DE DEVOLUCION'
END
GO
 
EXEC TB_SELECT_DEVOLUCION '202201001'

EXEC TB_SELECT_DEVOLUCION '202201004'
GO

CREATE PROCEDURE TB_VECHICULO_CONDUCTOR
(@p_DNI CHAR(10))
AS
BEGIN
IF EXISTS (SELECT * FROM [dbo].[GUIA_REMISION] WHERE DNI=@p_DNI)
	SELECT emp.DNI,emp.NOMBRE,emp.APELLIDO,gui.NUM_GUI,gui.FECHA,flo.PLACA,flo.MARCA
	FROM [dbo].[EMPLEADO]emp,[dbo].[FLOTA_VEHICULAR]flo,[dbo].[GUIA_REMISION]gui
	WHERE gui.Dni =@p_DNI AND
	gui.COD_FLO=flo.COD_FLO AND
	gui.DNI=emp.DNI
ELSE 
	PRINT'No es conductor '
END
GO

EXEC TB_VECHICULO_CONDUCTOR '72641525'

SELECT * FROM[dbo].[EMPLEADO]
GO 

CREATE PROCEDURE TB_VENTA_CAJERO
(@p_DNI CHAR(10))
AS
BEGIN
IF EXISTS (SELECT * FROM [dbo].[COMPRBANTE_VENTA] WHERE DNI=@p_DNI)
	SELECT emp.DNI,emp.NOMBRE,emp.APELLIDO,com.NUM_COM,com.FECHA,com.COD_TIE
	FROM [dbo].[EMPLEADO]emp,[dbo].[COMPRBANTE_VENTA]com
	WHERE com.DNI =@p_DNI AND
	emp.DNI=com.DNI
ELSE 
	PRINT'No es CAJERO '
END
GO
EXEC TB_VENTA_CAJERO '10245783'

SELECT * FROM[dbo].[EMPLEADO]
GO

CREATE PROCEDURE TB_NUEVOS_DATOS_PROVEEDOR(
@p_RUC VARCHAR(11),
@p_RAZ_SOC VARCHAR(50),
@p_DIR_PROV VARCHAR(100),
@p_TEL_PROV INT,
@p_TIP_PROV VARCHAR(20)
)
AS
BEGIN
	IF EXISTS ( SELECT * FROM [dbo].[PROVEEDOR] WHERE RUC=@p_RUC)
	UPDATE [dbo].[PROVEEDOR] SET RAZ_SOC=@p_RAZ_SOC,DIR_PROV=@p_DIR_PROV,TEL_PROV=@p_TEL_PROV,TIP_PROV=@p_TIP_PROV WHERE RUC=@p_RUC
	ELSE 
	PRINT 'NO EXISTE EL NUMERO DE RUC'
END
GO

EXEC TB_NUEVOS_DATOS_PROVEEDOR '201027485','NESTLE SAA','CARRETERA CENTRAL 155 LA VICTORIA',3267450,'ALIMENTOS'

SELECT * FROM [dbo].[PROVEEDOR] WHERE RUC='20102552369'
GO

CREATE PROCEDURE TB_DELETE_ORDEN_DESPACHO
(@p_NUM_DES INT)
AS
IF NOT EXISTS(SELECT * FROM [dbo].[ORDEN_DESPACHO] WHERE NUM_DES=@p_NUM_DES)
	PRINT 'EL NUMERO DE ORDEN DE DESPACHO NO EXISTE'
	ELSE IF EXISTS(SELECT * FROM [dbo].[GUIA_REMISION] WHERE NUM_ORD=@p_NUM_DES)
		PRINT 'LA ORDEN DE DESPACHO ESTA SUJETO A UNA GUIA DE REMISION'
ELSE
BEGIN
	DELETE [dbo].[ORDEN_DESPACHO] WHERE NUM_DES=@p_NUM_DES
END
GO

INSERT INTO [dbo].[ORDEN_DESPACHO] VALUES(20221020,100,'TL001',100,'1002','2022-06-25',20)
GO
EXEC TB_DELETE_ORDEN_DESPACHO '20221011'
GO
SELECT * FROM [dbo].[GUIA_REMISION]
GO


CREATE PROCEDURE TB_CONTAR_VENTAS_MENSUAL
AS
BEGIN
SELECT MONTH(FECHA)AS MES,
	COUNT(*) AS [CANTIDAD DE VENTAS],
	SUM(PRECIO) AS [TOTAL VENTAS]
	FROM [dbo].[COMPRBANTE_VENTA]
	GROUP BY MONTH(FECHA)
END
GO

EXEC TB_CONTAR_VENTAS_MENSUAL

INSERT INTO [dbo].[COMPRBANTE_VENTA] VALUES(00100011,'2022-08-13',101,2,'MUEBLE','350','10245783','10452563','TL004')
GO

CREATE PROCEDURE TB_NUEVOS_DATOS_EMPLEADOS(
@p_DNI CHAR(10),
@p_NOMBRE VARCHAR(50),
@p_APELLIDO VARCHAR(50),
@p_TEL_EMP CHAR(9),
@p_TIPO VARCHAR(20),
@p_SEXO CHAR(1),
@p_EDAD CHAR(5),
@p_DIRECCION VARCHAR(50)
)
AS
BEGIN
	IF EXISTS ( SELECT * FROM [dbo].[EMPLEADO] WHERE DNI=@p_DNI)
	UPDATE  [dbo].[EMPLEADO]SET NOMBRE=@p_NOMBRE,APELLIDO=@p_APELLIDO,TEL_EMP=@p_TEL_EMP,TIPO=@p_TIPO,SEXO=@p_SEXO,EDAD=@p_EDAD,DIRECCION=@p_DIRECCION WHERE DNI=@p_DNI
	ELSE 
	PRINT 'NO EXISTE EL DOCUMENTO DE IDENTIDAD'
END
GO

EXEC TB_NUEVOS_DATOS_EMPLEADOS '72641525','ALEJANDRO','LOPEZ','923581745','CONDUCTOR','M','32','CALLE LAS FLORES 155 RIMAC'

SELECT * FROM [dbo].[EMPLEADO] WHERE DNI='72641525'
GO

----- PROCEDIMIENTOS ALMACENADOS REGLAS DE NEGOCIO--------

CREATE PROCEDURE TB_CODIGO_IDENTIFICACION
AS
BEGIN
SELECT DNI AS [CODIGO DE IDENTIFICACION],
COUNT(*)[CANTIDAD DE EMPLEADOS POR CODIGO]
FROM [dbo].[EMPLEADO] 
GROUP BY DNI
END
GO

EXEC TB_CODIGO_IDENTIFICACION
GO

CREATE PROCEDURE TRANSPORTE_MERCADERIA_INTERNA
AS
BEGIN
SELECT NUM_DES,COD_CENT,COD_ALMA FROM [dbo].[ORDEN_DESPACHO]
END
GO

EXEC TRANSPORTE_MERCADERIA_INTERNA
GO

CREATE PROCEDURE MERCADERIA_AUTORIZADA
AS
BEGIN
SELECT NUM_ORD,COD_PRO,CANTIDAD,APROB FROM [dbo].[ORDEN_COMPRA]
END
GO

EXEC MERCADERIA_AUTORIZADA






