create database remedialu3;
use remedialu3;

create table usuarios(id int primary key not null auto_increment,
                      nombre varchar(20),
                      apellido varchar(20),
                      username varchar(16),
                      pass varchar(16));

create table articulos(id int primary key auto_increment not null,
					   nombre_articulo varchar(50),
                       descripcion text,
                       precio double,
                       cantidad int);
                       
create table clientes(id int primary key auto_increment not null,
                      nombre varchar(20),
                      apellido varchar(20),
                      email varchar(45),
                      telefono varchar(10),
                      calle varchar(25),
                      numero int,
                      colonia varchar(50));
                      