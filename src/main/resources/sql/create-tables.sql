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