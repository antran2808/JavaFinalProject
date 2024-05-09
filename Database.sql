USE [master]
GO
/****** Object:  Database [EstateManager]    Script Date: 5/7/2024 3:08:35 PM ******/
CREATE DATABASE [EstateManager]
GO
USE [EstateManager]
GO
/****** Object:  Table [dbo].[Booking]    Script Date: 5/7/2024 3:08:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booking](
	[id] [char](20) NOT NULL,
	[purpose] [int] NOT NULL,
	[created_date] [datetime] NULL,
	[estate_id] [char](20) NOT NULL,
	[customer_id] [char](20) NOT NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Estates]    Script Date: 5/7/2024 3:08:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estates](
	[id] [char](20) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[images] [varchar](max) NOT NULL,
	[description] [varchar](max) NULL,
	[public_date] [datetime] NULL,
	[owner_id] [char](20) NOT NULL,
	[sell_price] [int] NULL,
	[rent_price] [int] NULL,
	[addresss] [varchar](max) NOT NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Estates] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 5/7/2024 3:08:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[id] [char](20) NOT NULL,
	[name] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 5/7/2024 3:08:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [char](20) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[username] [varchar](100) NOT NULL,
	[password] [varchar](max) NOT NULL,
	[first_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[phone] [varchar](12) NULL,
	[role_id] [char](20) NOT NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Booking] ADD  CONSTRAINT [DF_Booking_created_date]  DEFAULT (getdate()) FOR [created_date]
GO
ALTER TABLE [dbo].[Booking] ADD  CONSTRAINT [DF_Booking_status]  DEFAULT ((0)) FOR [status]
GO
ALTER TABLE [dbo].[Estates] ADD  CONSTRAINT [DF_Estates_public_date]  DEFAULT (getdate()) FOR [public_date]
GO
ALTER TABLE [dbo].[Estates] ADD  CONSTRAINT [DF_Estates_status]  DEFAULT ((0)) FOR [status]
GO
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [DF_Users_status]  DEFAULT ((0)) FOR [status]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Estates] FOREIGN KEY([estate_id])
REFERENCES [dbo].[Estates] ([id])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Estates]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_Users] FOREIGN KEY([customer_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_Users]
GO
ALTER TABLE [dbo].[Estates]  WITH CHECK ADD  CONSTRAINT [FK_Estates_Users] FOREIGN KEY([owner_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[Estates] CHECK CONSTRAINT [FK_Estates_Users]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles] FOREIGN KEY([role_id])
REFERENCES [dbo].[Roles] ([id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles]
GO
