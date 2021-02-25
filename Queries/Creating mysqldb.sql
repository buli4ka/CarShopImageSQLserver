#create database CarShop;

USE CarShop;



CREATE TABLE body_type_tbl (
	id int auto_increment NOT NULL primary key,
	body_type_name nvarchar(20) NOT NULL
)
CREATE TABLE manufacturer_tbl(
	id int auto_increment NOT NULL primary key,
	manufacturer_name nvarchar(30) NOT NULL
)


CREATE TABLE car_model_tbl(
	id int auto_increment NOT NULL primary key,
	car_model_name nvarchar(30) NOT NULL,
	manufacturer_id int NULL,
	FOREIGN KEY(manufacturer_id) REFERENCES manufacturer_tbl (id) 
)

CREATE TABLE car_tbl(
	id int auto_increment NOT NULL primary key,	
	Price float8 NOT NULL,

	manufacturer_id int NULL,
	FOREIGN KEY(manufacturer_id) REFERENCES manufacturer_tbl (id),
	
	body_type_id int NULL,
	FOREIGN KEY(body_type_id) REFERENCES body_type_tbl (id),

	year_of_issue smallint NULL,	

	car_model_id int NULL,
	FOREIGN KEY(car_model_id) REFERENCES car_model_tbl (id),	

	car_description text

)


CREATE TABLE images_tbl(
	id int auto_increment NOT NULL primary key,
	image_name varchar (255),
	image_type varchar (10),
	image MEDIUMBLOB NOT NULL,
	image_path varchar (255),
	car_id int,
	FOREIGN KEY(car_id) REFERENCES car_tbl (id)	
);



