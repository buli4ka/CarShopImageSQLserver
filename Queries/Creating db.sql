--create database CarShop

--USE CarShop
--GO



--CREATE TABLE [dbo].[body_type_tbl](
--	[id] int IDENTITY(1,1) NOT NULL primary key,
--	[body_type_name] nvarchar(20) NOT NULL,
--)
--CREATE TABLE [dbo].[manufacturer_tbl](
--	[id] int IDENTITY(1,1) NOT NULL primary key,
--	[manufacturer_name] nvarchar(30) NOT NULL,
--)


--CREATE TABLE [dbo].[car_model_tbl](
--	[id] int IDENTITY(1,1) NOT NULL primary key,
--	car_model_name nvarchar(30) NOT NULL,
--	[manufacturer_id] int NULL,
--	FOREIGN KEY([manufacturer_id]) REFERENCES manufacturer_tbl ([id]) 
--)

--CREATE TABLE [dbo].[car_tbl](
--	[id] int IDENTITY(1,1) NOT NULL primary key,	
--	[Price] [money] NOT NULL,

--	[manufacturer_id] [int] NULL,
--	FOREIGN KEY([manufacturer_id]) REFERENCES manufacturer_tbl ([id]),
	
--	body_type_id [int] NULL,
--	FOREIGN KEY(body_type_id) REFERENCES body_type_tbl ([id]),

--	year_of_issue smallint NULL,	

--	car_model_id [int] NULL,
--	FOREIGN KEY(car_model_id) REFERENCES car_model_tbl ([id]),	

--	car_description nvarchar(max),

--)


--CREATE TABLE [dbo].[images_tbl](
--	[id] int IDENTITY(1,1) NOT NULL primary key,
--	[image_name] varchar (255),
--	[image_type] varchar (10),
--	[image] image NOT NULL,
--  image_path varchar(100),
--	car_id int,
--	FOREIGN KEY(car_id) REFERENCES car_tbl ([id]),	
--)



------to think

------CREATE TABLE [dbo].[urls_tbl](
------	[id] int IDENTITY(1,1) NOT NULL primary key,
------	[url_name] varchar (50),
------	[url_value] varchar (50),	
------)
