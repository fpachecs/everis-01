################################################################
# Esquema E/R muy resumido que simula operaciones en un banco.
# @Autor: Fernando Ismael Pacheco Sánchez (fips).
# @web: www.fernandopacheco.es
################################################################
drop database if exists banco;
create database banco;
use banco;

# Contiene información realacionada con datos identificativos de un usuario.
create table Usuario (
	id int auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    dni varchar(9) not null,
    constraint PK_Usuario primary key (id),
    constraint UK_Usuario_dni unique key (dni)
);

# Contiene información ralacionada con el acceso a la aplicación. 
create table UsuarioLogin (
	id int auto_increment,
    user varchar(50) not null,
    pass varchar(50) not null,
    idUser int not null,
    ultimoAcceso datetime not null,
    constraint PK_UsuarioLogin primary key (id),
    constraint UK_UsuarioLogin_user unique key (user),
	constraint FK_UsuarioLogin_Usuario foreign key (idUser) references Usuario (id)
		on delete restrict
        on update cascade
);

# Contiene información relacionada con una cuenta de usuario.
create table Cuenta(
	id int auto_increment,
    idUser int not null,
    numCuenta varchar(35) not null default "ESXX EEEE OOOO CC NNNNNNNNNN",
    nomBanco varchar(50) not null default "N/A",
    saldo decimal(22,2) not null default 0.00,
    fechaDeAlta datetime not null,
    constraint PK_Cuenta primary key (id),
	constraint FK_Cuenta_Usuario foreign key (idUser) references Usuario (id)
		on delete restrict
        on update cascade
);

# Contiene informaión relacionada con movimientos de una cuenta.
create table Movimiento(
	id int auto_increment,
    idCuenta int not null,
    fechaOperacion datetime not null,
    cantidad decimal(12,2) not null,
    tipoOperacion varchar(45),
    constraint PK_Movimiento primary key (id),
    constraint FK_Movimiento_Cuenta foreign key (idCuenta) references Cuenta (id)
		on delete restrict
        on update cascade
);

insert into Usuario values
(1, "Fernando", "Pacheco", "55526889S"),
(2, "David", "Claro", "00000000A"),
(3, "Antonio", "Carrión", "00000000B"),
(4, "David", "Donamaria", "77856923N");

insert into UsuarioLogin values
(1, "fpachecs", "admin", 1, current_timestamp()),
(2, "declaroba", "declaroba", 2, current_timestamp()),
(3, "acarriom", "acarriom", 3, current_timestamp()),
(4, "donamuso", "donamuso", 4, current_timestamp());

insert into Cuenta values
(1, 1, "ES00 0049 0000 10 1000000000", "Santander", 100000.00, current_timestamp()),
(2, 1, "ES00 0232 0000 10 1000000001", "Inversis", 100000.00, current_timestamp()),
(3, 2, "ES00 2038 0000 20 2000000000", "Bankia", 100000.00, current_timestamp()),
(4, 3, "ES00 0232 0000 30 3000000000", "Inversis", 100000.00, current_timestamp()),
(5, 4, "ES00 0635 0000 40 4000000000", "Santander", 100000.00, current_timestamp()),
(6, 4, "ES00 0325 0000 40 4000000001", "EVO_Bank", 100000.00, current_timestamp()),
(7, 4, "ES00 4125 0000 40 4000000002", "BBVA", 100000.00, current_timestamp()),
(8, 4, "ES00 8941 0000 40 4000000003", "Inversis", 100000.00, current_timestamp()),
(9, 4, "ES00 1562 0000 40 4000000004", "ING_Direct", 100000.00, current_timestamp());

insert into Movimiento values
(1, 2, current_timestamp(), 100, "ingresar"),
(2, 2, current_timestamp(), -100, "extraer"),
(3, 5, current_timestamp(), -1000, "extraer"),
(4, 5, current_timestamp(), 1000, "ingresar"),
(5, 5, current_timestamp(), 500, "ingresar"),
(6, 5, current_timestamp(), 600, "ingresar");

