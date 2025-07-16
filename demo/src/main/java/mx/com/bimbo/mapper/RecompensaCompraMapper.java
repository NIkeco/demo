package mx.com.bimbo.mapper;

import java.time.LocalDateTime;

import mx.com.bimbo.data.persistence.model.RecompensaCompraEntity;
import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.recompensaCompraDTO;

public class RecompensaCompraMapper {

	public static RecompensaCompraEntity mapToRecompensaCompraEntiry (recompensaCompraDTO reCompra) {
		return 	new RecompensaCompraEntity(null,
				reCompra.getIdUsuario(), 
				reCompra.getIdRecompensa(),
				LocalDateTime.now(), 
				reCompra.getCantidad(), 
				reCompra.getMonto(), 
				reCompra.getDescripcion());
	}
	
	public static puntosEntity mapRecompensaCompraToPuntos (RecompensaCompraEntity recompensaCompra)
	{
		return new puntosEntity (recompensaCompra.getIdUsuario(),
				"C",
				recompensaCompra.getFecha(),
				recompensaCompra.getDescripcion(),
				recompensaCompra.getMonto());
	}
	
}
