create  database ebay_db;

use ebay_db;

create table customers(
id bigint(15) not null auto_increment,
name varchar(100) not null,
email varchar(100) not null,
phone varchar(20),
primary key (id)
);

create table customer_login(
id bigint(15) not null auto_increment,
username varchar(100) not null,
password varchar(100) not null,
created_at datetime not null,
updated_at datetime ,
last_signed_on datetime,
customer_id bigint(15) not null,
primary key (id),
foreign key (customer_id) references customers(id)
);

alter table customer_login add  
CONSTRAINT username_uniquek UNIQUE (username);

create table category(
id bigint(15) not null auto_increment,
name varchar(100) not null,
description varchar(100) not null,
created_at datetime not null,
primary key (id)
);

create table products(
id bigint(15) not null auto_increment,
name varchar(100) not null,
description varchar(100) not null,
created_at datetime not null,
brand varchar(30),
category_id bigint(15) not null,
price double,
is_available boolean default true,
primary key (id),
foreign key(category_id) references category(id) 
);