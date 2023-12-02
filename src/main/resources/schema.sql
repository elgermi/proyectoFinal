CREATE DATABASE venta1;
use venta1;

create table clientes(
      id int primary key auto_increment,
      nombre varchar(70),
      apellido varchar(70),
      documento varchar(11)
);

create table productos(
      id int primary key auto_increment,
      descripcion varchar(150),
      codigo varchar(50),
      stock int,
      precio double
);

create table factura(
      id int primary key auto_increment,
      clientes_id int,
      fecha_creacion datetime,
      total double,
      constraint fk_clientes_id FOREIGN key (clientes_id) references clientes(id)
);

create table detalle_factura(
     id int primary key auto_increment,
     factura_id int,
     cantidad_productos int,
     productos_id int,
     importe double,
     constraint fk_factura_id foreign key (factura_id) references factura(id),
     constraint fk_productos_id foreign key (productos_id) references productos(id)
);