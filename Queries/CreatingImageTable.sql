USE CarShop
GO



CREATE TABLE [dbo].[images_TBL](
	[id] int IDENTITY(1,1) NOT NULL primary key,
	[image_name] varchar (255),
	[image_type] varchar (10),
	[image] image NOT NULL,
)


