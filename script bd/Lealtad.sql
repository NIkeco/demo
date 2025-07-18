USE [Lealtad]
GO
/****** Object:  Table [dbo].[Puntos]    Script Date: 15/07/2025 07:37:25 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Puntos](
	[idUsuario] [bigint] NOT NULL,
	[Transaccion] [varchar](1) NOT NULL,
	[Fecha] [datetime] NOT NULL,
	[Descripcion] [varchar](50) NOT NULL,
	[Monto] [numeric](8, 0) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recompensa]    Script Date: 15/07/2025 07:37:26 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recompensa](
	[idRecompensa] [bigint] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Descripcion] [varchar](250) NULL,
	[Valor] [numeric](5, 0) NOT NULL,
 CONSTRAINT [PK_Recompensa] PRIMARY KEY CLUSTERED 
(
	[idRecompensa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RecompensaCompra]    Script Date: 15/07/2025 07:37:26 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RecompensaCompra](
	[idRecompensaCompra] [bigint] IDENTITY(1,1) NOT NULL,
	[idUsuario] [bigint] NOT NULL,
	[idRecompensa] [bigint] NOT NULL,
	[Fecha] [datetime] NULL,
	[Cantidad] [int] NOT NULL,
	[Monto] [numeric](8, 0) NOT NULL,
	[Descripcion] [varchar](100) NULL,
 CONSTRAINT [PK_RecompensaCompra] PRIMARY KEY CLUSTERED 
(
	[idRecompensaCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 15/07/2025 07:37:26 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[idUsuario] [bigint] IDENTITY(1,1) NOT NULL,
	[usuario] [varchar](20) NOT NULL,
	[contraseña] [varchar](300) NOT NULL,
	[fecha] [numeric](8, 0) NOT NULL,
	[saldo] [numeric](8, 0) NOT NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [idx_idusuario_fecha]    Script Date: 15/07/2025 07:37:26 p. m. ******/
CREATE NONCLUSTERED INDEX [idx_idusuario_fecha] ON [dbo].[Puntos]
(
	[idUsuario] ASC,
	[Fecha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [idx_nombre]    Script Date: 15/07/2025 07:37:26 p. m. ******/
CREATE UNIQUE NONCLUSTERED INDEX [idx_nombre] ON [dbo].[Recompensa]
(
	[Nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [idx_idusuario_fecha]    Script Date: 15/07/2025 07:37:26 p. m. ******/
CREATE NONCLUSTERED INDEX [idx_idusuario_fecha] ON [dbo].[RecompensaCompra]
(
	[idUsuario] ASC,
	[Fecha] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [idx_idUsuario]    Script Date: 15/07/2025 07:37:26 p. m. ******/
CREATE UNIQUE NONCLUSTERED INDEX [idx_idUsuario] ON [dbo].[Usuario]
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Puntos]  WITH CHECK ADD  CONSTRAINT [FK_Puntos_Usuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Usuario] ([idUsuario])
GO
ALTER TABLE [dbo].[Puntos] CHECK CONSTRAINT [FK_Puntos_Usuario]
GO
ALTER TABLE [dbo].[RecompensaCompra]  WITH CHECK ADD  CONSTRAINT [FK_RecompensaCompra_Recompensa] FOREIGN KEY([idRecompensa])
REFERENCES [dbo].[Recompensa] ([idRecompensa])
GO
ALTER TABLE [dbo].[RecompensaCompra] CHECK CONSTRAINT [FK_RecompensaCompra_Recompensa]
GO
ALTER TABLE [dbo].[RecompensaCompra]  WITH CHECK ADD  CONSTRAINT [FK_RecompensaCompra_Usuario] FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Usuario] ([idUsuario])
GO
ALTER TABLE [dbo].[RecompensaCompra] CHECK CONSTRAINT [FK_RecompensaCompra_Usuario]
GO
/****** Object:  StoredProcedure [dbo].[sp_ResgistraPuntos_Cta]    Script Date: 15/07/2025 07:37:26 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Moiseés Nicolón Monzón Hopyos
-- Create date: 20250713
-- Description:	Registro de puntos a una cuenta de Bimbo
-- =============================================
CREATE PROCEDURE [dbo].[sp_ResgistraPuntos_Cta]
	@IdUsuario bigint,
	@transaccion varchar(1),
	@descripcion varchar(50),
	@monto numeric(8,0),
	@fecha datetime
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;


	IF @transaccion = 'C'
	BEGIN
		set @monto = @monto * -1
	END
	ELSE
	BEGIN
		set @monto = ABS(@monto)
	END
		

    BEGIN TRANSACTION

	INSERT INTO Puntos
		(idUsuario, Transaccion, Fecha, Descripcion, Monto)
	VALUES (@IdUsuario, @transaccion, ISNULL(@fecha, GETDATE()), @descripcion, @monto)

	UPDATE Usuario SET
		saldo = saldo + @monto
	WHERE idUsuario = @IdUsuario

	COMMIT TRANSACTION

	
END

GO
