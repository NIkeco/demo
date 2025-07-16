package mx.com.bimbo.data.persistence.service;

import mx.com.bimbo.data.persistence.model.puntosEntity;
import mx.com.bimbo.dto.puntosDTO;

public interface IPuntosService {

	public Integer RegistraPuntos (puntosDTO puntosDto);
	
	public Integer RegistraPuntos (puntosEntity puntosEnn);
}
