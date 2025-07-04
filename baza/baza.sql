USE [master]
GO
/****** Object:  Database [springapp]    Script Date: 6/6/2025 5:19:17 PM ******/
CREATE DATABASE [springapp]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springapp', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\springapp.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'springapp_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\springapp_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [springapp] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springapp].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [springapp] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [springapp] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [springapp] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [springapp] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [springapp] SET ARITHABORT OFF 
GO
ALTER DATABASE [springapp] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [springapp] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [springapp] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [springapp] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [springapp] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [springapp] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [springapp] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [springapp] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [springapp] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [springapp] SET  DISABLE_BROKER 
GO
ALTER DATABASE [springapp] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [springapp] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [springapp] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [springapp] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [springapp] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [springapp] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [springapp] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [springapp] SET RECOVERY FULL 
GO
ALTER DATABASE [springapp] SET  MULTI_USER 
GO
ALTER DATABASE [springapp] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [springapp] SET DB_CHAINING OFF 
GO
ALTER DATABASE [springapp] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [springapp] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [springapp] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [springapp] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'springapp', N'ON'
GO
ALTER DATABASE [springapp] SET QUERY_STORE = ON
GO
ALTER DATABASE [springapp] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [springapp]
GO
/****** Object:  Table [dbo].[app_iznajmljivanje]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_iznajmljivanje](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[idVozila] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_objava]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_objava](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[naslov] [varchar](50) NULL,
	[sadrzaj] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_promocija]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_promocija](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[naslov] [varchar](50) NULL,
	[opis] [varchar](200) NULL,
	[datumTrajanja] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_user]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_user](
	[username] [nvarchar](50) NOT NULL,
	[password_hash] [nvarchar](50) NOT NULL,
	[deaktiviran] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Automobil]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Automobil](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[iznajmljeno] [bit] NOT NULL,
	[pokvaren] [bit] NOT NULL,
	[proizvodjac_id] [int] NOT NULL,
	[cijenaIznajmljivanja] [varchar](255) NULL,
	[cijenaNabavke] [varchar](255) NULL,
	[datumNabavke] [varchar](255) NULL,
	[model] [varchar](255) NULL,
	[objectId] [varchar](255) NULL,
	[opis] [varchar](255) NULL,
	[slika] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Automobil_Iznajmljivanje]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Automobil_Iznajmljivanje](
	[Automobil_id] [int] NOT NULL,
	[iznajmljivanja_id] [int] NOT NULL,
 CONSTRAINT [UKlek81eet937fbyi11x1j96s5j] UNIQUE NONCLUSTERED 
(
	[iznajmljivanja_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Automobil_Kvar]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Automobil_Kvar](
	[Automobil_id] [int] NOT NULL,
	[kvarovi_id] [int] NOT NULL,
 CONSTRAINT [UK27yqq4la9n0xh154mljhlyadi] UNIQUE NONCLUSTERED 
(
	[kvarovi_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniBicikl]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniBicikl](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[iznajmljeno] [bit] NOT NULL,
	[pokvaren] [bit] NOT NULL,
	[proizvodjac_id] [int] NOT NULL,
	[autonomija] [varchar](255) NULL,
	[cijenaIznajmljivanja] [varchar](255) NULL,
	[cijenaNabavke] [varchar](255) NULL,
	[model] [varchar](255) NULL,
	[objectId] [varchar](255) NULL,
	[slika] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniBicikl_Iznajmljivanje]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniBicikl_Iznajmljivanje](
	[ElektricniBicikl_id] [int] NOT NULL,
	[iznajmljivanja_id] [int] NOT NULL,
 CONSTRAINT [UKrv8qtya60ndn40p017ipulome] UNIQUE NONCLUSTERED 
(
	[iznajmljivanja_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniBicikl_Kvar]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniBicikl_Kvar](
	[ElektricniBicikl_id] [int] NOT NULL,
	[kvarovi_id] [int] NOT NULL,
 CONSTRAINT [UKe2f02ja545cpj0bvmdi82yrp5] UNIQUE NONCLUSTERED 
(
	[kvarovi_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniTrotinet]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniTrotinet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[iznajmljeno] [bit] NOT NULL,
	[pokvaren] [bit] NOT NULL,
	[proizvodjac_id] [int] NOT NULL,
	[cijenaIznajmljivanja] [varchar](255) NULL,
	[cijenaNabavke] [varchar](255) NULL,
	[maksimalnaBrzina] [varchar](255) NULL,
	[model] [varchar](255) NULL,
	[objectId] [varchar](255) NULL,
	[slika] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniTrotinet_Iznajmljivanje]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniTrotinet_Iznajmljivanje](
	[ElektricniTrotinet_id] [int] NOT NULL,
	[iznajmljivanja_id] [int] NOT NULL,
 CONSTRAINT [UKbg3uddgedmwo0f1b7wuhd49fc] UNIQUE NONCLUSTERED 
(
	[iznajmljivanja_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ElektricniTrotinet_Kvar]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ElektricniTrotinet_Kvar](
	[ElektricniTrotinet_id] [int] NOT NULL,
	[kvarovi_id] [int] NOT NULL,
 CONSTRAINT [UK1jx0f9hy0yeu707d68q1a6bvl] UNIQUE NONCLUSTERED 
(
	[kvarovi_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Iznajmljivanje]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Iznajmljivanje](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[datum] [varchar](255) NULL,
	[identifickacioniDokument] [varchar](255) NULL,
	[konacnaLokacija] [varchar](255) NULL,
	[trenutnaLokacija] [varchar](255) NULL,
	[vozackaDozvola] [varchar](255) NULL,
	[vrijeme] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Korisnik]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Korisnik](
	[blokiran] [bit] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[avatar] [varchar](255) NULL,
	[brojLicneKarte] [varchar](255) NULL,
	[brojPasosa] [varchar](255) NULL,
	[brojTelefona] [varchar](255) NULL,
	[brojVozackeDozvole] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[hash] [varbinary](255) NULL,
	[ime] [varchar](255) NULL,
	[korisnickoIme] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[prezime] [varchar](255) NULL,
	[role] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kvar]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kvar](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[datum] [varchar](255) NULL,
	[opis] [varchar](255) NULL,
	[vrijeme] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proizvodjac]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proizvodjac](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[adresa] [varchar](255) NULL,
	[drzava] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[fax] [varchar](255) NULL,
	[naziv] [varchar](255) NULL,
	[telefon] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Zaposleni]    Script Date: 6/6/2025 5:19:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Zaposleni](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[password] [varchar](255) NULL,
	[role] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Automobil]  WITH CHECK ADD  CONSTRAINT [FKp0wid9n6cm8fcw101f3qfpgg4] FOREIGN KEY([proizvodjac_id])
REFERENCES [dbo].[Proizvodjac] ([id])
GO
ALTER TABLE [dbo].[Automobil] CHECK CONSTRAINT [FKp0wid9n6cm8fcw101f3qfpgg4]
GO
ALTER TABLE [dbo].[Automobil_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FK41ererjcwlmgao3x2sb809pu0] FOREIGN KEY([iznajmljivanja_id])
REFERENCES [dbo].[Iznajmljivanje] ([id])
GO
ALTER TABLE [dbo].[Automobil_Iznajmljivanje] CHECK CONSTRAINT [FK41ererjcwlmgao3x2sb809pu0]
GO
ALTER TABLE [dbo].[Automobil_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FK919yjahjr4d9ym81vh8w65x4n] FOREIGN KEY([Automobil_id])
REFERENCES [dbo].[Automobil] ([id])
GO
ALTER TABLE [dbo].[Automobil_Iznajmljivanje] CHECK CONSTRAINT [FK919yjahjr4d9ym81vh8w65x4n]
GO
ALTER TABLE [dbo].[Automobil_Kvar]  WITH CHECK ADD  CONSTRAINT [FKi4ybv7wop9ofc11oprx1prflc] FOREIGN KEY([kvarovi_id])
REFERENCES [dbo].[Kvar] ([id])
GO
ALTER TABLE [dbo].[Automobil_Kvar] CHECK CONSTRAINT [FKi4ybv7wop9ofc11oprx1prflc]
GO
ALTER TABLE [dbo].[Automobil_Kvar]  WITH CHECK ADD  CONSTRAINT [FKsa4i96r1vcmd699qh4gbobwdc] FOREIGN KEY([Automobil_id])
REFERENCES [dbo].[Automobil] ([id])
GO
ALTER TABLE [dbo].[Automobil_Kvar] CHECK CONSTRAINT [FKsa4i96r1vcmd699qh4gbobwdc]
GO
ALTER TABLE [dbo].[ElektricniBicikl]  WITH CHECK ADD  CONSTRAINT [FKk4llqb599aj2x74cgtvg1nqam] FOREIGN KEY([proizvodjac_id])
REFERENCES [dbo].[Proizvodjac] ([id])
GO
ALTER TABLE [dbo].[ElektricniBicikl] CHECK CONSTRAINT [FKk4llqb599aj2x74cgtvg1nqam]
GO
ALTER TABLE [dbo].[ElektricniBicikl_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FK8egqduruf5jowaxfglvxjpqw8] FOREIGN KEY([iznajmljivanja_id])
REFERENCES [dbo].[Iznajmljivanje] ([id])
GO
ALTER TABLE [dbo].[ElektricniBicikl_Iznajmljivanje] CHECK CONSTRAINT [FK8egqduruf5jowaxfglvxjpqw8]
GO
ALTER TABLE [dbo].[ElektricniBicikl_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FKoh3b69iom6eiyujm58h56sbc8] FOREIGN KEY([ElektricniBicikl_id])
REFERENCES [dbo].[ElektricniBicikl] ([id])
GO
ALTER TABLE [dbo].[ElektricniBicikl_Iznajmljivanje] CHECK CONSTRAINT [FKoh3b69iom6eiyujm58h56sbc8]
GO
ALTER TABLE [dbo].[ElektricniBicikl_Kvar]  WITH CHECK ADD  CONSTRAINT [FKdey44vqlo80cgx6sg2yc6g6b1] FOREIGN KEY([kvarovi_id])
REFERENCES [dbo].[Kvar] ([id])
GO
ALTER TABLE [dbo].[ElektricniBicikl_Kvar] CHECK CONSTRAINT [FKdey44vqlo80cgx6sg2yc6g6b1]
GO
ALTER TABLE [dbo].[ElektricniBicikl_Kvar]  WITH CHECK ADD  CONSTRAINT [FKl6446juorctrio9atw5lhw7lg] FOREIGN KEY([ElektricniBicikl_id])
REFERENCES [dbo].[ElektricniBicikl] ([id])
GO
ALTER TABLE [dbo].[ElektricniBicikl_Kvar] CHECK CONSTRAINT [FKl6446juorctrio9atw5lhw7lg]
GO
ALTER TABLE [dbo].[ElektricniTrotinet]  WITH CHECK ADD  CONSTRAINT [FK3plqdeehxdg1wvaiqsfbnp3qe] FOREIGN KEY([proizvodjac_id])
REFERENCES [dbo].[Proizvodjac] ([id])
GO
ALTER TABLE [dbo].[ElektricniTrotinet] CHECK CONSTRAINT [FK3plqdeehxdg1wvaiqsfbnp3qe]
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FK2hnx4dhkj3ap97gm1s0fvn27j] FOREIGN KEY([ElektricniTrotinet_id])
REFERENCES [dbo].[ElektricniTrotinet] ([id])
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Iznajmljivanje] CHECK CONSTRAINT [FK2hnx4dhkj3ap97gm1s0fvn27j]
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Iznajmljivanje]  WITH CHECK ADD  CONSTRAINT [FKbf7vji9by5a4th31tkxyhuvi5] FOREIGN KEY([iznajmljivanja_id])
REFERENCES [dbo].[Iznajmljivanje] ([id])
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Iznajmljivanje] CHECK CONSTRAINT [FKbf7vji9by5a4th31tkxyhuvi5]
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Kvar]  WITH CHECK ADD  CONSTRAINT [FK1j6demkgdi83xig5ndri32jns] FOREIGN KEY([kvarovi_id])
REFERENCES [dbo].[Kvar] ([id])
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Kvar] CHECK CONSTRAINT [FK1j6demkgdi83xig5ndri32jns]
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Kvar]  WITH CHECK ADD  CONSTRAINT [FKh3hvpx26a0y42wowpk1a3lhp8] FOREIGN KEY([ElektricniTrotinet_id])
REFERENCES [dbo].[ElektricniTrotinet] ([id])
GO
ALTER TABLE [dbo].[ElektricniTrotinet_Kvar] CHECK CONSTRAINT [FKh3hvpx26a0y42wowpk1a3lhp8]
GO
USE [master]
GO
ALTER DATABASE [springapp] SET  READ_WRITE 
GO
