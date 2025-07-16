package mx.com.bimbo.mapper;

import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.puntosDTO;

public class puntosMapper {
	
	public static puntosEntity mapToPuntos (puntosDTO puntos)	{
		return new puntosEntity(puntos.getIdUsuario(), 
				puntos.getTransaccion().toUpperCase(), 
				null, 
				puntos.getDescripcion(), 
				puntos.getMonto());
	}

	

}
